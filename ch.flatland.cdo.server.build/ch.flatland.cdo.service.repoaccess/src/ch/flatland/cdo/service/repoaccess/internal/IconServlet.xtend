/*
 * Copyright (c) 2014 Robert Blust (Zurich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.service.repoaccess.internal

import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.EMF
import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import com.google.common.base.Splitter
import java.io.BufferedInputStream
import java.net.URL
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class IconServlet extends AbstractServlet {
	
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		val logger = LoggerFactory.getLogger(this.class)
		
		val extension Request = new Request
		val extension Response = new Response
		val extension EMF = new EMF
		
		val extension JsonConverter = req.createJsonConverter
		
		req.logRequest

		val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))

		var pathInfo = req.pathInfo
		if(pathInfo == null) {
			pathInfo = ""
		}

		try {
			val pathSegments = Splitter.on("/").split(pathInfo)
			switch (pathSegments.size) {
				case 2: {
					try {
						var EObject object = null 
						var typeSegment = pathSegments.get(1)
						if (typeSegment == "eresource.CDOResource") {
							// TODO use different icon can be done better
							typeSegment = "security.ResourceFilter"
						}
						if (typeSegment.contains(".")) {
							val segments = Splitter.on(".").split(typeSegment)
							val ePackage = safeEPackage(segments.get(0))
							val eClass = safeEClass(ePackage, segments.get(1))
							object = ePackage.EFactoryInstance.create(eClass)
						} else {
							throw new Exception
						}
						
						val imageUrl = ITEM_DELEGATOR.getImage(object) as URL
						if(imageUrl == null) {
							throw new Exception
						}

						val image = new BufferedInputStream(imageUrl.openStream)
						val out = resp.getOutputStream()
						val buffer = newByteArrayOfSize(8192)

						for (var int length; (length = image.read(buffer)) > 0;) {
							out.write(buffer, 0, length)
						}

						resp.setContentType(GIF_CONTENTTYPE)

						image.close
						out.close
					} catch(Exception e) {
						throw new FlatlandException(SC_NOT_FOUND, "Icon for '{}' not found", pathInfo)
					}
				}
				default:
					throw new FlatlandException(SC_NOT_FOUND, "Icon '{}' not found", pathInfo)
			}

		} catch(FlatlandException e) {
			resp.status = e.httpStatus
			resp.writeResponse(req, e.safeToJson)
			logger.error("Request failed", e)
		}
	}
}

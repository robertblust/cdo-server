/*
 * Copyright (c) 2014 Robert Blust (Zürich, Switzerland) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Robert Blust - initial API and implementation
 */
package ch.flatland.cdo.service.repoaccess

import ch.flatland.cdo.util.AbstractServlet
import ch.flatland.cdo.util.EMF
import ch.flatland.cdo.util.FlatlandException
import ch.flatland.cdo.util.Request
import ch.flatland.cdo.util.Response
import com.google.common.base.Splitter
import java.net.URL
import javax.imageio.ImageIO
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.emf.cdo.view.CDOView
import org.eclipse.emf.edit.EMFEditPlugin
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.slf4j.LoggerFactory

import static ch.flatland.cdo.util.Constants.*
import static javax.servlet.http.HttpServletResponse.*

class IconServlet extends AbstractServlet {
	override protected doGet(HttpServletRequest req, HttpServletResponse resp) {
		logRequest(req)

		val logger = LoggerFactory.getLogger(this.class)
		val extension Request = new Request
		val extension Response = new Response
		val extension EMF = new EMF
		val extension JsonConverter = req.createJsonConverter

		val ITEM_DELEGATOR = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry))
		val CDOView view = SessionFactory.getCDOSession(req).openView

		var pathInfo = req.pathInfo
		if(pathInfo == null) {
			pathInfo = ""
		}

		try {
			val pathSegments = Splitter.on("/").split(pathInfo)
			switch (pathSegments.size) {
				case 2: {
					val object = view.safeCreateType(pathSegments.get(1))
					val imageUrl = ITEM_DELEGATOR.getImage(object) as URL
					if (imageUrl == null) {
						throw new FlatlandException(SC_NOT_FOUND, "Icon for '{}' not found", pathInfo)
					}
					val image = ImageIO.read(imageUrl)

					resp.setContentType(GIF_CONTENTTYPE)
					val out = resp.getOutputStream()
					ImageIO.write(image, GIF_FORMAT, out)
					out.close();
				}
				default:
					throw new FlatlandException(SC_NOT_FOUND, "Icon '{}' not found", pathInfo)
			}

		} catch(FlatlandException e) {
			resp.status = e.httpStatus
			resp.writeResponse(req, e.safeToJson)
			logger.error("Request failed", e)
		} finally {
			if(view != null && !view.closed) {
				view.close
			}
		}
	}
}

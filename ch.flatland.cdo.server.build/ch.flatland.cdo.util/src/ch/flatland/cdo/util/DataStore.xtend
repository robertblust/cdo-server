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
package ch.flatland.cdo.util

import org.eclipse.emf.cdo.CDOObject
import org.eclipse.emf.cdo.view.CDOView
import org.slf4j.LoggerFactory

class DataStore {
	val logger = LoggerFactory.getLogger(this.class)

	def findByType(CDOView view, String type) {

		// TODO sql depends on mapping strategy
		val result = newArrayList

		//val query = view.createQuery("ocl", type.safeEType + ".allInstances()")
		val query = view.createQuery("sql", "SELECT cdo_id FROM " + type.replace(".", "_") + " WHERE cdo_revised = 0 and cdo_version > 0")
		logger.debug("Execute '{}' query '{}'", query.queryLanguage, query.queryString)
		val iterator = query.getResultAsync(typeof(CDOObject))
		while(iterator.hasNext) {
			val obj = iterator.next
			logger.debug("Found '{}'", obj)
			result.add(obj)
		}
		iterator.close
		return result
	}
}

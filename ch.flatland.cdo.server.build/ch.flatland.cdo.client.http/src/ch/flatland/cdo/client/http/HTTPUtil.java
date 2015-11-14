/*
 * Copyright (c) 2008, 2011, 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Robert Blust - support https
 */
package ch.flatland.cdo.client.http;

import org.eclipse.net4j.http.common.IHTTPConnector;
import org.eclipse.net4j.util.container.IManagedContainer;

import ch.flatland.cdo.client.internal.http.HTTPSConnectorFactory;

/**
 * A utility class with static convenience methods.
 * 
 * @author Eike Stepper
 */
public final class HTTPUtil {
	private HTTPUtil() {
	}

	public static void prepareContainer(IManagedContainer container) {
		container.registerFactory(new HTTPSConnectorFactory());
	}

	/**
	 * @since 2.0
	 */
	public static IHTTPConnector getConnector(IManagedContainer container, String description) {
		return (IHTTPConnector) container.getElement(HTTPSConnectorFactory.PRODUCT_GROUP, HTTPSConnectorFactory.TYPE, description);
	}
}

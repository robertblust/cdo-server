/*
 * Copyright (c) 2008, 2009, 2011, 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Eike Stepper - initial API and implementation
 *    Robert Blust - support https
 */
package ch.flatland.cdo.client.internal.http;

import org.eclipse.net4j.http.internal.common.bundle.OM;
import org.eclipse.spi.net4j.ConnectorFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Eike Stepper
 */
@SuppressWarnings("restriction")
public class HTTPSConnectorFactory extends ConnectorFactory {
	private static final String HTTP_SCHEME_PREFIX = "https://"; //$NON-NLS-1$

	public static final String TYPE = "https"; //$NON-NLS-1$

	public HTTPSConnectorFactory() {
		super(TYPE);
	}

	public HTTPSClientConnector create(String description) {
		String userID = null;
		if (!description.startsWith(HTTP_SCHEME_PREFIX)) {
			description = HTTP_SCHEME_PREFIX + description;
		}

		try {
			URL url = new URL(description);
			userID = url.getUserInfo();
		} catch (MalformedURLException ex) {
			OM.LOG.error(ex);
		}

		HTTPSClientConnector connector = new HTTPSClientConnector();
		connector.setURL(description);
		connector.setUserID(userID);
		return connector;
	}

	@Override
	public String getDescriptionFor(Object object) {
		if (object instanceof HTTPSClientConnector) {
			HTTPSClientConnector connector = (HTTPSClientConnector) object;
			return connector.getURL();
		}

		return null;
	}
}

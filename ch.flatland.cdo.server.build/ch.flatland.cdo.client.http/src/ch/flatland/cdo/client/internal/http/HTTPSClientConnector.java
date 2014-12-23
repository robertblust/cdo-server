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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.eclipse.net4j.http.internal.common.HTTPConnector;
import org.eclipse.net4j.util.concurrent.Worker;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.io.ExtendedDataInputStream;
import org.eclipse.net4j.util.io.ExtendedDataOutputStream;
import org.eclipse.net4j.util.io.ExtendedIOAdapter;
import org.eclipse.net4j.util.io.ExtendedIOHandler;
import org.eclipse.net4j.util.io.IORuntimeException;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.net4j.util.om.log.OMLogger;
import org.eclipse.spi.net4j.InternalChannel;

/**
 * @author Eike Stepper
 */
@SuppressWarnings("restriction")
public class HTTPSClientConnector extends HTTPConnector {
	private String url;

	private HttpClient httpClient;

	private int maxIdleTime = UNKNOWN_MAX_IDLE_TIME;

	private int pollInterval = DEFAULT_POLL_INTERVAL;

	private long lastRequest = System.currentTimeMillis();

	private boolean requesting;

	private Worker poller = new Worker() {
		@Override
		protected void work(WorkContext context) throws Exception {
			boolean moreBuffers = tryOperationsRequest();
			context.nextWork(moreBuffers ? 0 : 1000);
		}
	};

	public HTTPSClientConnector() {
	}

	@Override
	public Location getLocation() {
		return Location.CLIENT;
	}

	@Override
	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public int getMaxIdleTime() {
		return maxIdleTime;
	}

	public int getPollInterval() {
		return pollInterval;
	}

	public void setPollInterval(int pollInterval) {
		this.pollInterval = pollInterval;
	}

	@Override
	public void multiplexChannel(InternalChannel channel) {
		super.multiplexChannel(channel);
		tryOperationsRequest();
	}

	@Override
	public String toString() {
		if (getUserID() == null) {
			return MessageFormat.format("HTTPSClientConnector[{0}]", getURL()); //$NON-NLS-1$
		}

		return MessageFormat.format("HTTPSClientConnector[{1}@{0}]", getURL(), getUserID()); //$NON-NLS-1$
	}

	@Override
	protected void doBeforeActivate() throws Exception {
		super.doBeforeActivate();
		checkArg(url, "url == null"); //$NON-NLS-1$
	}

	@Override
	protected void doActivate() throws Exception {
		super.doActivate();
		poller.setDaemon(true);
		poller.activate();
		httpClient = createHTTPClient();
		doConnect();
	}

	@Override
	protected void doDeactivate() throws Exception {
		doDisconnect();
		LifecycleUtil.deactivate(poller, OMLogger.Level.WARN);
		httpClient = null;
		super.doDeactivate();
	}

	protected HttpClient createHTTPClient() {
		return new HttpClient();
	}

	protected PostMethod createHTTPMethod(String url) {
		return new PostMethod(url);
	}

	private void doConnect() throws IOException {
		request(new ExtendedIOHandler() {
			public void handleOut(ExtendedDataOutputStream out) throws IOException {
				out.writeByte(OPCODE_CONNECT);
				out.writeString(getUserID());
			}

			public void handleIn(ExtendedDataInputStream in) throws IOException {
				String connectorID = in.readString();
				maxIdleTime = in.readInt();

				setConnectorID(connectorID);
				leaveConnecting();
			}
		});
	}

	private void doDisconnect() throws IOException {
		request(new ExtendedIOAdapter() {
			@Override
			public void handleOut(ExtendedDataOutputStream out) throws IOException {
				out.writeByte(OPCODE_DISCONNECT);
				out.writeString(getConnectorID());
			}
		});
	}

	private void request(ExtendedIOHandler handler) throws IOException, HttpException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ExtendedDataOutputStream out = new ExtendedDataOutputStream(baos);
		handler.handleOut(out);
		out.flush();

		PostMethod method = createHTTPMethod(url);
		method.setRequestEntity(new ByteArrayRequestEntity(baos.toByteArray()));

		try {
			httpClient.executeMethod(method);
			InputStream bodyInputStream = method.getResponseBodyAsStream();
			ExtendedDataInputStream in = new ExtendedDataInputStream(bodyInputStream);
			handler.handleIn(in);

		} finally {
			method.releaseConnection();
		}
	}

	private boolean tryOperationsRequest() {
		synchronized (poller) {
			if (requesting) {
				return false;
			}

			if (getOutputQueue().isEmpty() && System.currentTimeMillis() - lastRequest < pollInterval) {
				return false;
			}

			requesting = true;
		}

		try {
			final boolean moreOperations[] = { false };
			request(new ExtendedIOHandler() {
				public void handleOut(ExtendedDataOutputStream out) throws IOException {
					out.writeByte(OPCODE_OPERATIONS);
					out.writeString(getConnectorID());
					moreOperations[0] = writeOutputOperations(out);
				}

				public void handleIn(ExtendedDataInputStream in) throws IOException {
					readInputOperations(in);
				}
			});

			lastRequest = System.currentTimeMillis();
			return moreOperations[0];
		} catch (IOException ex) {
			// added by Robert Blust
			poller.deactivate();
			// added by Robert Blust
			IPluginContainer.INSTANCE.clearElements();
			throw new IORuntimeException(ex);
		} finally {
			synchronized (poller) {
				requesting = false;
			}
		}
	}
}
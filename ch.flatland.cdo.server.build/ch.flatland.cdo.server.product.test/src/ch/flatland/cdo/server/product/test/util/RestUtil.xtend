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
package ch.flatland.cdo.server.product.test.util

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import org.apache.commons.codec.binary.Base64
import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.HttpMethodBase
import org.apache.commons.httpclient.methods.DeleteMethod
import org.apache.commons.httpclient.methods.GetMethod
import org.apache.commons.httpclient.methods.PostMethod
import org.apache.commons.httpclient.methods.PutMethod
import org.apache.commons.httpclient.methods.StringRequestEntity
import org.apache.commons.io.IOUtils

class RestUtil {

	val static SYSTEM_PARAM_PORT = "org.eclipse.equinox.http.jetty.http.port"
	val static PORT = System.getProperty(SYSTEM_PARAM_PORT, "8199")
	val parser = new JsonParser
	val builder = new GsonBuilder().setPrettyPrinting.create

	def getServerUrl() {
		"http://localhost:" + PORT
	}

	def GET(HttpClient httpClient, String path) {
		val getMethod = new GetMethod(serverUrl + path)
		getMethod.addRequestHeader("Accept", "application/json")
		return getMethod
	}
	
	def DELETE(HttpClient httpClient, String path) {
		val deleteMethod = new DeleteMethod(serverUrl + path)
		deleteMethod.addRequestHeader("Accept", "application/json")
		return deleteMethod
	}

	def POST(HttpClient httpClient, String path, String json) {
		val requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
		val postMethod = new PostMethod(serverUrl + path);
		postMethod.addRequestHeader("Accept", "application/json")
		postMethod.setRequestEntity(requestEntity);
		return postMethod
	}
	
	def PUT(HttpClient httpClient, String path, String json) {
		val requestEntity = new StringRequestEntity(json, "application/json", "UTF-8");
		val putMethod = new PutMethod(serverUrl + path);
		putMethod.addRequestHeader("Accept", "application/json")
		putMethod.setRequestEntity(requestEntity);
		return putMethod
	}

	def getResponseJson(HttpMethodBase method) {
		method.responseBodyAsStream
		val br = new BufferedReader(new InputStreamReader(method.responseBodyAsStream))

		val builder = new StringBuilder
		var String line

		while((line = br.readLine()) !== null) {
			builder.append(line)
		}
		parser.parse(builder.toString)
	}

	def isStatusOK(JsonElement response) {
		if(response.jsonObject) {
			val jsonObject = response.asJsonObject
			val statusObject = jsonObject?.getAsJsonObject("status")
			val status = statusObject?.getAsJsonPrimitive("status")?.asString
			if(status !== null && status == "OK") {
				return true
			}
		}
		return false
	}

	def isStatusError(JsonElement response) {
		if(response.jsonObject) {
			val jsonObject = response.asJsonObject
			val status = jsonObject?.getAsJsonPrimitive("status")?.asString
			if(status !== null && status == "ERROR") {
				return true
			}
		}
		return false
	}

	def getData(JsonElement response) {
		response.asJsonObject.get("data")
	}
	
	def getSelfLink(JsonElement response) {
		response.asJsonObject.getAsJsonObject("data").getAsJsonObject("_links").getAsJsonObject("self").getAsJsonPrimitive("href").asString
	}
	
	def getEAttribute(JsonElement object, String attributeName) {
		object.asJsonObject.getAsJsonObject("attributes").getAsJsonPrimitive(attributeName)
	}
	
	def getEReference(JsonElement object, String referenceName) {
		object.asJsonObject.getAsJsonObject("references").get(referenceName)
	}

	def toPrettyJson(JsonElement jsonElement) {
		builder.toJson(jsonElement)
	}
	
	def asBase64String(InputStream inputStream) {
		Base64.encodeBase64String(IOUtils.toByteArray(inputStream))
	}
}
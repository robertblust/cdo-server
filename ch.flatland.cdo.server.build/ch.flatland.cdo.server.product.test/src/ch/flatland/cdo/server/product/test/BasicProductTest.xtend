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
package ch.flatland.cdo.server.product.test

import ch.flatland.cdo.server.product.test.util.RestUtil
import org.apache.commons.httpclient.HttpClient
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

import static org.junit.Assert.*

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class BasicProductTest {

	// use one global httpClient instance
	// this reuses the http session between different request
	// to same repository
	val static httpClient = new HttpClient
	val static extension RestUtil = new RestUtil

	@Test
	def void testRepo0Request1() {

		val GET = httpClient.GET("/node/repo")

		httpClient.executeMethod(GET)

		assertEquals(200, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusOK)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo0Request2() {

		val GET = httpClient.GET("/obj/repo/eresource.CDOResource/1")

		httpClient.executeMethod(GET)

		assertEquals(200, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusOK)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo0CreateResource1() {
		// first create resource
		val postJson = '''
			{
				"type": "eresource.CDOResource",
				"attributes": {
					"name": "Test Resource 1"
				}
			}
		'''
		val POST = httpClient.POST("/obj/repo/eresource.CDOResource/1/references/contents", postJson)

		httpClient.executeMethod(POST)

		assertEquals(201, POST.statusCode)

		val postResponse = POST.responseJson
		val selfLink = postResponse.selfLink

		assertTrue(postResponse.isStatusOK)

		println(postResponse.toPrettyJson)

		POST.releaseConnection

		// and now rename it
		val putJson = '''
			{
				"attributes": {
					"name": "RENAMED Test Resource 1"
				}
			}
		'''
		val PUT = httpClient.PUT(selfLink, putJson)

		httpClient.executeMethod(PUT)

		assertEquals(200, PUT.statusCode)

		val putResponse = PUT.responseJson

		assertTrue(putResponse.isStatusOK)

		println(putResponse.toPrettyJson)

		PUT.releaseConnection

		// and now delete it
		val DELETE = httpClient.DELETE(selfLink)

		httpClient.executeMethod(DELETE)

		assertEquals(200, DELETE.statusCode)

		val deleteResponse = DELETE.responseJson

		assertTrue(deleteResponse.isStatusOK)

		println(deleteResponse.toPrettyJson)

		DELETE.releaseConnection
	}

	@Test
	def void testRepo0CreateResource2() {
		// first create resource
		val postJson = '''
			{
				"type": "eresource.CDOResource",
				"attributes": {
					"name": "Test Resource 2"
				}
			}
		'''
		val POST = httpClient.POST("/obj/repo/eresource.CDOResource/1/references/contents", postJson)

		httpClient.executeMethod(POST)

		assertEquals(201, POST.statusCode)

		val postResponse = POST.responseJson
		val selfLink = postResponse.selfLink

		assertTrue(postResponse.isStatusOK)

		println(postResponse.toPrettyJson)

		POST.releaseConnection

		// and now rename it
		val putJson = '''
			{
				"attributes": {
					"name": "RENAMED Test Resource 2"
				}
			}
		'''
		val PUT = httpClient.PUT(selfLink, putJson)

		httpClient.executeMethod(PUT)

		assertEquals(200, PUT.statusCode)

		val putResponse = PUT.responseJson

		assertTrue(putResponse.isStatusOK)

		println(putResponse.toPrettyJson)

		PUT.releaseConnection

		// and now delete it
		val DELETE = httpClient.DELETE(selfLink)

		httpClient.executeMethod(DELETE)

		assertEquals(200, DELETE.statusCode)

		val deleteResponse = DELETE.responseJson

		assertTrue(deleteResponse.isStatusOK)

		println(deleteResponse.toPrettyJson)

		DELETE.releaseConnection
	}

	@Test
	def void testRepo0Error() {

		val GET = httpClient.GET("/node/repo/notfound")

		httpClient.executeMethod(GET)

		assertEquals(404, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusError)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo2Request1() {

		val GET = httpClient.GET("/node/repo2")

		httpClient.executeMethod(GET)

		assertEquals(200, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusOK)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo2Request2() {

		val GET = httpClient.GET("/obj/repo2/eresource.CDOResource/1")

		httpClient.executeMethod(GET)

		assertEquals(200, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusOK)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo2Error() {

		val GET = httpClient.GET("/node/repo2/notfound")

		httpClient.executeMethod(GET)

		assertEquals(404, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusError)

		println(response.toPrettyJson)

		GET.releaseConnection
	}

	@Test
	def void testRepo3NotExisting() {

		val GET = httpClient.GET("/node/repo3")

		httpClient.executeMethod(GET)

		assertEquals(400, GET.statusCode)

		val response = GET.responseJson

		assertTrue(response.isStatusError)

		println(response.toPrettyJson)

		GET.releaseConnection
	}
}

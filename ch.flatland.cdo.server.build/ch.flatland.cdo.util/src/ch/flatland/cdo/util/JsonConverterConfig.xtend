package ch.flatland.cdo.util

class JsonConverterConfig {
	String servletUrl
	String servletContext
	var meta = false
	
	new(String servletUrl, String servletContext) {
		this.servletUrl = servletUrl
		this.servletContext = servletContext
	}
	
	def getServerUrl() {
		servletUrl.replace(servletContext, "")
	}
	
	def getServletUrl() {
		servletUrl
	}
	
	def getServletContext() {
		servletContext
	}
	
	def isMeta() {
		meta
	}
	
	def setMeta(boolean meta) {
		this.meta = meta
	}
}
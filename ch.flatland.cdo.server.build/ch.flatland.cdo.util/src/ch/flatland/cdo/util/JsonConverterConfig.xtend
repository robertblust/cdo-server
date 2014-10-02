package ch.flatland.cdo.util

import org.eclipse.xtend.lib.annotations.Data

@Data class JsonConverterConfig {
	String servletUrl
	String servletContext
	
	def getServerUrl() {
		servletUrl.replace(servletContext, "")
	}
}
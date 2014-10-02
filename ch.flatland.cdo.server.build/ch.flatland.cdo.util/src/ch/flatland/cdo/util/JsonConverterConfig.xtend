package ch.flatland.cdo.util

import org.eclipse.xtend.lib.annotations.Data

@Data class JsonConverterConfig {
	String servletUrl
	String servletContext
	
	def getServerUrl2() {
		servletUrl.replace(servletContext, "")
	}
}
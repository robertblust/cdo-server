package ch.flatland.cdo.service.ping.model

import org.eclipse.xtend.lib.annotations.Data

@Data
class Info {
	Build build
}

@Data
class Build {
	String artifact = "ch.flatland.cdo.server"
	String name = "cdo-service"
	String version
	String group = "ch.flatland"
}

package ch.flatland.cdo.server

import org.eclipse.emf.cdo.security.User

class UserUtil {
	public val static ADMIN_USER = User.ADMINISTRATOR
	public val static ADMIN_PWD = System.getProperty("ch.flatland.cdo.server.admin.pwd")
	public val static READONLY_USER = "ReadOnly"
	public val static READONLY_PWD = System.getProperty("ch.flatland.cdo.server.readonly.pwd")
}
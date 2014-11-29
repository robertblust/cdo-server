##Flatland CDO Server

The goal of this project is to provide an [OSGI equinox] application server.

##Features
* __[CDO Model Repository]__
	* Storage of [EMF - Eclipse Modeling Framework] base model instances
	* LDAP user authentication (basic auth)
	* CDO internal user authorization
* __Rest API__ for accessing and manipulating model instances
	* Delegates security to CDO
	* Operates on EMF refelctive API
	* Mimetype __application/json; charset=utf-8__

## Component Model
![Feature Model]
(https://github.com/robertblust/cdo-server/blob/master/ch.flatland.cdo.doc/images/component.png)


##License
[Eclipse Public License Version 1.0 ("EPL")]




[OSGI equinox]:https://www.eclipse.org/equinox/
[CDO Model Repository]:https://www.eclipse.org/cdo/
[EMF - Eclipse Modeling Framework]:https://www.eclipse.org/modeling/emf/
[Eclipse Public License Version 1.0 ("EPL")]:http://www.eclipse.org/legal/epl-v10.html

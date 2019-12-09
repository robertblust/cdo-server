#!/bin/bash

/opt/cdo/bin/flatland-cdo-server -vmargs \
-Dorg.eclipse.equinox.http.jetty.http.host=0.0.0.0 \
-Dorg.eclipse.equinox.http.jetty.http.port=8199 \
-Dorg.eclipse.equinox.http.jetty.http.enabled=true \
-Dch.flatland.cdo.db.connection.url=${MYSQL_JDBC_URL} \
-Dch.flatland.cdo.db.connection.username=${MYSQL_USER} \
-Dch.flatland.cdo.db.connection.password=${MYSQL_PASSWORD} \
-Dorg.eclipse.equinox.http.jetty.context.sessioninactiveinterval=0 \
-Dlogback.configurationFile=/opt/cdo/bin/logback.xml \
-Dch.flatland.cdo.server.config=/opt/cdo/config.json

while true 
	do sleep 1
done
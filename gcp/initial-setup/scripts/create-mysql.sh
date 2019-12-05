#!/usr/bin/env bash

echo "install mysql"
helm install --name mysql-cdo -f values_mysql.yaml stable/mysql


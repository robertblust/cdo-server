#!/bin/bash


PID=$(ps -ef | grep flatland-cdo-server | grep -v grep | awk '{ print $2 }')
echo $PID

if [ ! -z "$PID" ]
then
  kill -9 $PID 
fi
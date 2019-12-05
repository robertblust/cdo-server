#!/usr/bin/env bash

#exit with error if e.g. kubectl commands return error code
set -e

if [ $# -ne 2 ]; then
  echo "Expecting two arguments - Docker image tag and environment!"
  exit 1
fi

DOCKER_IMAGE_TAG=$1
echo "Docker image tag: '$DOCKER_IMAGE_TAG'"

ENV=$2
if [ "$ENV" = "dev" ] || [ "$ENV" = "test" ] || [ "$ENV" = "prod" ]; then
  echo "Environment: '$ENV'"
else
  echo "Invalid environment ($ENV) - use one of (dev|test|prod)."
fi

echo "--------------------------------------------------------------------------------"
echo "create deployment and service 'cdo-service'..."
cat cdo-deployment.yml | sed "s/@@IMAGE_TAG@@/$DOCKER_IMAGE_TAG/g" | sed "s/@@ENV@@/$ENV/g" | kubectl apply -f -
kubectl apply -f cdo-service.yml

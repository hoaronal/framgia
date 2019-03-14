#!/bin/sh
if [ "$SKIP_TEST" = true ] ; then
   ./mvnw clean install -DskipTests
else
  ./mvnw clean install
fi
docker-compose down
docker-compose up --build

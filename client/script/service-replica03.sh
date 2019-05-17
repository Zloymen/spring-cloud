#!/bin/sh

java -jar -Dspring.profiles.active=abc-service-replica03 ../target/client.jar
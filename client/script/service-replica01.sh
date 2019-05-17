#!/bin/sh

java -jar -Dspring.profiles.active=abc-service-replica01 ../target/client.jar
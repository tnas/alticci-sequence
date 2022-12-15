#!/bin/bash

docker build -t tnas/alticci-api:1.0 .
docker run --name alticci-api -p 8080:8080 tnas/alticci-api:1.0

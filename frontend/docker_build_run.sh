#!/bin/bash

docker build -t tnas/alticci-spa:1.0 .
docker run --name alticci-spa -p 8000:80 tnas/alticci-spa:1.0

#!/bin/bash
#./mvnw spring-boot:build-image
docker build -t scenario-system:latest .
docker run -d -p 9876:9876 -t scenario-system:latest
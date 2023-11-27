#!/bin/bash

# Step 1: Clean and build with Maven
mvn clean install

# Step 2: Build server-image and db-image Docker images
docker build -t server-image --target server-image -f Dockerfile .
docker build -t db-image --target db-image -f Dockerfile .

# Step 3: Build and run Docker Compose
docker-compose build
docker-compose up

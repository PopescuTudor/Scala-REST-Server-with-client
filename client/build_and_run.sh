#!/bin/bash

# Step 1: Compile with Maven
mvn compile

# Step 2: Run Scala application
mvn scala:run -DmainClass=com.app.client.Client
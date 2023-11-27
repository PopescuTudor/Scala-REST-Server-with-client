# Scala-REST-Server-with-client
A Scala based REST server, using Spring-Boot, connected to a PostgreSQL db. This repository also contains a Client app that sends messages to the server. 

## Prerequisites
Before running this project, ensure that you have the following tools installed on your machine:

- **Maven:** Maven is used for building the project. You can download it from [https://maven.apache.org/](https://maven.apache.org/).

- **Docker:** Docker is used for containerization of (only) the server and database. You can download it from [https://www.docker.com/](https://www.docker.com/).

- **JDK (Java Development Kit):** Make sure you have a JDK installed.

## Project Structure

The project is organized into two main folders:

- **/RESTscala:** Contains the server application.
- **/client:** Contains the client application.

Each folder has its own `build_and_run.sh` script for convenience.

## Running the Server

   ```bash
   cd RESTscala
   chmod +x ./build_and_run.sh
   ./build_and_run.sh
   ```
## Running the Server

   ```bash
   cd client
   chmod +x ./build_and_run.sh
   ./build_and_run.sh
   ```

## Important! Messages format

### In command line, after running the client app, you can send the following three types of messages:
1. Message to be saved in db (example: Ana are mere [domain:domestic] [fruit:mar])
2. Retrieve statistics(example: /stats 2022-02-01 00:00:00 2023-12-01 12:30:00)
    ! It's important to use this format: /stats YYYY-MM-DD HH:MM:SS YYYY-MM-DD HH:MM:SS 
3. Quitting the app (example: exit)


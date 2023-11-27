
FROM postgres:latest AS db-image

ENV POSTGRES_DB = messages_bd
ENV POSTGRES_USER = postgres
ENV POSTGRES_PASSWORD = 12345

FROM eclipse-temurin:17-jdk-jammy AS server-image

WORKDIR /app

COPY /target/RESTscala-0.0.1-SNAPSHOT.jar /app/server-app.jar

EXPOSE 8080

CMD ["java", "-jar", "server-app.jar"]



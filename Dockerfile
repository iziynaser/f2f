FROM maven:3.9.6-eclipse-temurin-21 AS builder

ENV APP_NAME=f2fcore
##ENV SPRING_PROFILES_ACTIVE=docker

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests


FROM eclipse-temurin:21-jre-jammy

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/f2fdb
ENV SPRING_DATASOURCE_USERNAME=f2fuser
ENV SPRING_DATASOURCE_PASSWORD=f2fpass
ENV SPRING_PROFILES_ACTIVE=dev

WORKDIR /app
COPY f2fc/target/f2f-c-1.0.0.war /app/app.war

RUN mkdir -p /app/images

EXPOSE 8080
EXPOSE 5005

ENTRYPOINT java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=0.0.0.0:5006 -jar /app/app.war

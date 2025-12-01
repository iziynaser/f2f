##FROM openjdk:17-jdk-slim as builder
FROM maven:3.9.6-eclipse-temurin-21 AS builder

ENV APP_NAME=f2fcore

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

##FROM openjdk:17-jre-slim
FROM eclipse-temurin:21-jre-jammy

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/f2fdb
ENV SPRING_DATASOURCE_USERNAME=f2fuser
ENV SPRING_DATASOURCE_PASSWORD=f2fpass
ENV SPRING_PROFILES_ACTIVE=dev

WORKDIR /app

##COPY --from=builder /app/target/f2f-c-1.0.0.war /app/app.war
COPY f2fc/target/f2f-c-1.0.0.war /app/app.war

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.war"]

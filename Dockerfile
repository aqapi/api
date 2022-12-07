# package
FROM gradle:jdk17-alpine AS build
WORKDIR /usr/app/
COPY build.gradle settings.gradle ./
COPY gradle gradle
COPY src src
RUN gradle clean build
RUN ls build/**

# app
FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY --from=build /usr/app/build/libs/measuringStation.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

# package
FROM gradle:jdk17-alpine AS build
WORKDIR /usr/app/
COPY build.gradle settings.gradle ./
COPY gradle gradle
COPY src src
RUN gradle clean build
RUN ls build/**

# app
FROM openjdk:20-ea-17-jdk-slim
RUN groupadd -r app && useradd -r -g app app
COPY --from=build /usr/app/build/libs/measuringStation-0.0.1-SNAPSHOT.jar /home/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/home/app/app.jar"]

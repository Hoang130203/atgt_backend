#
# Build stage
#
FROM docker.io/library/maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY . /app/
RUN mvn clean package

#
# Package stage
#
FROM docker.io/library/adoptopenjdk/openjdk17:alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
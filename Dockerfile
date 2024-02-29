FROM ubuntu:lastest AS build
RUN app-get update
RUN app-get install openjdk-21-jdk -y
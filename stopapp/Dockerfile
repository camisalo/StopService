FROM openjdk:8-jdk-alpine
MAINTAINER Konrad Gebczynski
ENV app_name target/stopapp-1.0-SNAPSHOT.jar
COPY ${app_name} stopapp.jar
ENTRYPOINT ["java","-jar","/stopapp.jar"]
FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/timesheet-ci-1.0.jar timesheet-ci-1.0.jar
ENTRYPOINT ["java","-jar","timesheet-ci-1.0.jar"]
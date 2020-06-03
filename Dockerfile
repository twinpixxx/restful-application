FROM openjdk:8-jdk-alpine

COPY build/libs/triangful-0.1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
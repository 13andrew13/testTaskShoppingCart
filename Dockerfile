FROM openjdk:8-jdk-alpine
EXPOSE 8081
ENTRYPOINT ./mvnw spring-boot:run
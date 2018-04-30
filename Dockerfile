FROM openjdk:alpine
RUN apt-get install maven
RUN mvn spring-boot:run
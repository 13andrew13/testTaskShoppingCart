FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD webapp/build/libs/UserCart-1.0-SNAPSHOT.jar /usr/src/rivals/
WORKDIR /usr/src/rivals
ENTRYPOINT exec java $JAVA_OPTS -jar UserCart-1.0-SNAPSHOT.jar
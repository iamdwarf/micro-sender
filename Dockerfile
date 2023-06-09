FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ./target/micro-sender-0.0.1-SNAPSHOT.jar sender.jar
ENTRYPOINT ["java", "-jar", "/sender.jar"]
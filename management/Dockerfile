FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=./target/management-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/application.jar"]

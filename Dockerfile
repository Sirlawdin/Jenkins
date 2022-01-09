FROM openjdk:8-jre-alpine

EXPOSE 8080

COPY ./target/java-maven-jar-plugin:3.2.0:jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "java-maven-jar-plugin:3.2.0:jar"]

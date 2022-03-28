FROM maven:3.6.1-jdk-8-alpine as MAVEN_BUILD

COPY ./ ./

RUN mvn clean package


FROM openjdk:8-jre-alpine3.9

COPY --from=MAVEN_BUILD /target/file-reader-docker-1.0-SNAPSHOT.jar /demo.jar

CMD ["java", "-jar", "/demo.jar", "result-file"]



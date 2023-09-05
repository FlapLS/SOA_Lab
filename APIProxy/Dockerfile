#define base docker image
FROM openjdk:17
ADD target/APIProxy-1.0-SNAPSHOT.jar APIProxy.jar
ENTRYPOINT ["java", "-jar", "APIProxy.jar"]
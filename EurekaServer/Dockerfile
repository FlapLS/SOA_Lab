#define base docker image
FROM openjdk:17
ADD target/EurekaServer-1.0-SNAPSHOT.jar EurekaServer.jar
ENTRYPOINT ["java", "-jar", "EurekaServer.jar"]
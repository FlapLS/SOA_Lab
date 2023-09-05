#define base docker image
FROM openjdk:17
ADD target/SpacemarineService-1.0-SNAPSHOT.jar SpacemarineService.jar
ENTRYPOINT ["java", "-jar", "SpacemarineService.jar"]
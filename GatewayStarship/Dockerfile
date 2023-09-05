#define base docker image
FROM openjdk:17
ADD target/GatewayStarship-0.0.1-SNAPSHOT.jar GatewayStarship.jar
ENTRYPOINT ["java", "-jar", "GatewayStarship.jar"]
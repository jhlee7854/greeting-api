FROM --platform=$BUILDPLATFORM amazoncorretto:17
LABEL authors="jonghak"
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

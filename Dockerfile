FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build.gradle /app/

COPY src /app/src

RUN apt-get update && apt-get install -y gradle && gradle build -x test

COPY build/libs/*.jar app.jar

EXPOSE 8080

# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]

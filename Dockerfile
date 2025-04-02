FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build.gradle /app/
COPY settings.gradle /app/
COPY src /app/src/

RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl -sSL https://services.gradle.org/distributions/gradle-8.13-bin.zip -o gradle.zip && \
    unzip gradle.zip -d /opt && \
    rm gradle.zip && \
    ln -s /opt/gradle-8.13/bin/gradle /usr/bin/gradle

RUN gradle build -x test

RUN ls -l build/libs/

ADD build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

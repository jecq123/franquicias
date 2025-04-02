FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build.gradle /app/

COPY src /app/src

RUN apt-get update && \
    apt-get install -y curl unzip && \
    curl -sSL https://services.gradle.org/distributions/gradle-7.5.1-bin.zip -o gradle.zip && \
    unzip gradle.zip -d /opt && \
    rm gradle.zip && \
    ln -s /opt/gradle-7.5.1/bin/gradle /usr/bin/gradle


RUN gradle build -x test

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

FROM lippert/adoptopenjdk-17

EXPOSE 5500

ADD target/tem-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Use the OpenJDK image directly for runtime
FROM openjdk:22-bullseye

WORKDIR /app

COPY target/*.jar app.jar

CMD ["java", "--enable-preview", "-jar", "app.jar"]
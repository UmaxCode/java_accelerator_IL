FROM maven:3.9-eclipse-temurin-22 AS build

WORKDIR /app

COPY . .

RUN mvn package -DskipTests

FROM openjdk:21-bullseye

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8888

CMD ["java", "--enable-preview", "-jar", "app.jar"]
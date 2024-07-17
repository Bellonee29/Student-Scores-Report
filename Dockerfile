FROM maven:3.8.5-openjdk-17 AS build
LABEL authors="Wajiu Bello Olarewaju"
COPY . .
RUN mvn clean package -Pprod -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/stake9ja-0.0.1-SNAPSHOT.jar stake9ja.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "student-scores.jar"]
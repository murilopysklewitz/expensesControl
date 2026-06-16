FROM maven:3.9-eclipse-temurin-21 as BUILDER

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

copy src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin-21-jre

RUN adduser -r appuser
USER appuser
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM gradle:latest AS builder

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

RUN chmod +x gradlew
RUN ./gradlew clean build -x test

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
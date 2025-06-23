FROM openjdk:21-jdk-slim AS build
COPY . /app
WORKDIR /app
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:21-jre-alpine
COPY --from=build /app/target/taskManagement-0.0.1-SNAPSHOT.jar /taskManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java" ,"-jar" , "taskManagement-0.0.1-SNAPSHOT.jar"]
#
# Build stage
#
FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:17-jdk-slim AS production
COPY --from=build /target/team6-0.0.1-SNAPSHOT.jar team6.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","team6.jar"]
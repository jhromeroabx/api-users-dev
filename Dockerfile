#
# Build stage
#
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/api-users-0.0.1-SNAPSHOT.jar api-users.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","api-users.jar"]

# docker build -t java-api-users .

# docker run \
# --name api-users-webapi \
# --restart always \
# -d -p 8880:8080 java-api-users
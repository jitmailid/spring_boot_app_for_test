# Stage 1: To build the application
FROM maven:3.9.4-eclipse-temurin-17 AS maven_builder
LABEL stage=maven_builder
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the application
COPY src/ src/
RUN mvn clean package -DskipTests

# Stage 2: For openjdk (lightweight image)
FROM openjdk:17-jdk-slim
LABEL maintainer="DevOpsTeam"

# Create a non-root user for better security
RUN useradd -m appuser
USER appuser

WORKDIR /app
#RUN ls -al /app/target/
#COPY --from=builder /app/target/test-github-gist-api-0.0.1-SNAPSHOT app.jar
COPY --from=maven_builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
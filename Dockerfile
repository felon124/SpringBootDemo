# Use a base image with Java 17 installed
FROM openjdk:17-jdk-alpine

# Copy the JAR file into the container
COPY application.jar app.jar
COPY src/main/resources/application.yml application.yml
# Expose the port that the application will listen on
EXPOSE 8080
# Set the command to run the application when the container starts
CMD ["java", "-jar","app.jar", "--spring.config.location=application.yml"]
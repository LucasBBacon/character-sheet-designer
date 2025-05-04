# Dockerfile

# Use an official OpenJDK image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR / app

# Copy built application jar into the container
COPY target/character-sheet-designer-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
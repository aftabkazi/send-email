# Use lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built jar file into the image
COPY target/sendEmail-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 9094

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

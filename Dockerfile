# Use an OpenJDK 11 image
FROM adoptopenjdk:11-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the packaged WAR file from your local machine to the container folder
COPY target/francevolunteer-0.0.1-SNAPSHOT.war /app/app.war

# Expose port 8080 for the Tomcat server to listen on
EXPOSE 8090

# Set the entry point to run the Spring Boot application using the java command
CMD ["java", "-jar", "app.war"]
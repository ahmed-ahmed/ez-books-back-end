FROM openjdk:8

COPY target/api-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8000

CMD ["java", "-jar", "-Dspring.profiles.active=default", "/app.jar"]

FROM openjdk:17
COPY build/libs/ms-account-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-Dspring.profiles.active", "-jar", "app.jar"]
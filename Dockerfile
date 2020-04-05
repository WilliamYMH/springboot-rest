FROM openjdk:8
EXPOSE 8080
ADD target/e-reservation.jar e-reservation.jar
ENTRYPOINT ["java", "-jar", "/e-reservation.jar"]
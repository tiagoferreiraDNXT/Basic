FROM openjdk:18
EXPOSE 8081
ADD target/demo.jar demo.jar
ENTRYPOINT ["java", "-jar", "/demo.jar"]
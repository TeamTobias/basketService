# java spring-boot
FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/basketService-1.0.jar basketservice.jar
ENTRYPOINT ["java","-jar","basketservice.jar"]
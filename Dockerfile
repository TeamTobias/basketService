# java spring-boot
FROM adoptopenjdk/openjdk11
ADD build/libs/basketService-0.0.1-SNAPSHOT.jar basketService.jar
EXPOSE 8005
ENTRYPOINT ["java","-jar","basketService.jar"]
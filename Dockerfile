FROM openjdk:8
ADD target/spring-boot-ems-0.0.1-SNAPSHOT.war application.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","application.war"]
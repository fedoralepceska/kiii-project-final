FROM openjdk:8
EXPOSE 8080
ADD target/kiii-project.jar kiii-project.jar
ENTRYPOINT ["java","-jar","/kiii-project.jar"]
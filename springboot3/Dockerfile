FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/springboot3.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
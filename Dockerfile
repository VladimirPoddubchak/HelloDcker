FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/docker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN mkdir -p src/main/resources/
COPY src/main/resources/greeting.txt src/main/resources/greeting.txt
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

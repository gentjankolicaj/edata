#Fetching amazon version of java
FROM amazoncorretto:11

#Setting work dir
WORKDIR /app

#Copy from compile diretory to image work dir
COPY ./target/transform-service-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

#Expose port
EXPOSE 9000

#Execute command
ENTRYPOINT ["java","-jar","app.jar"]
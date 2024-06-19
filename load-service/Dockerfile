FROM amazoncorretto:11

WORKDIR /app

COPY ./target/load-service-1.0-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
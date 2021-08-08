FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8111

LABEL maintainer="arpan"
ADD ./target/spring-sql-example.jar spring-sql-example.jar
ENTRYPOINT ["java","-jar","spring-sql-example.jar"]
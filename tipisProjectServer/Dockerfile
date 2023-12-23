FROM maven:3.8.5-openjdk-17 as builder
WORKDIR /app
COPY . .
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/tipisProjectServer-0.0.1-SNAPSHOT.jar /app/tipisProjectServer-0.0.1-SNAPSHOT.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/app/tipisProjectServer-0.0.1-SNAPSHOT.jar"]
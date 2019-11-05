FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY ./ /app/
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "/app//target/jenkins-docker-0.0.1-SNAPSHOT.jar"]
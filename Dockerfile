FROM openjdk:11
VOLUME /tmp
WORKDIR /app/
COPY ./ .
RUN ./mvnw clean package -DskipTests
RUN mv /app/target/hr-user-0.0.1-SNAPSHOT.jar ./hr-user.jar
ENTRYPOINT [ "java", "-jar","hr-user.jar"]
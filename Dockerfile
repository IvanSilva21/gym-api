FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# Corrige permissões do Maven Wrapper
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/gym-api-0.0.1-SNAPSHOT.jar"]



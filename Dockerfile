# Usando JDK 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

# Se usa Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Se usa Gradle Wrapper
# RUN ./gradlew build -x test

CMD ["java", "-jar", "target/gym-api-0.0.1-SNAPSHOT.jar"]


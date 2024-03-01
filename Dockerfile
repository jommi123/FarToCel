FROM maven:latest

WORKDIR /app

COPY pom.xml /app/

COPY . /app/

RUN mvn package
# Run the main class (assuming your application has a main class)
CMD ["java", "-jar", "target/fahrtocel.jar"]

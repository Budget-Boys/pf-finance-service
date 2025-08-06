FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/*.jar app.jar
COPY wait-for-it.sh wait-for-it.sh

RUN chmod +x wait-for-it.sh

CMD ["./wait-for-it.sh", "pf-finance-mysql:3306", "--timeout=120", "--", "java", "-jar", "app.jar"]

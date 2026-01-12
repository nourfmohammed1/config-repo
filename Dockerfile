FROM eclipse-temurin:25.0.1_8-jre-alpine-3.23
RUN apk add --no-cache curl
VOLUME /tmp

EXPOSE 9001

ARG JAR_FILE=build/libs/*.jar

COPY ${JAR_FILE} patient-service.jar

ENTRYPOINT ["java", "-jar", "/patient-service.jar"]
FROM gradle:7.6.0-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build -x test --no-daemon

FROM openjdk:17-slim-bullseye
LABEL maintainer="Ivan Hayel <i.hayel.dev@gmail.com"
EXPOSE 8080
RUN mkdir /license-service
ARG JAR_FILE=/home/gradle/src/build/libs/licensing-service-0.0.1.jar
COPY --from=build ${JAR_FILE} /license-service/license-service.jar
ENTRYPOINT ["java", "-jar", "/license-service/license-service.jar"]
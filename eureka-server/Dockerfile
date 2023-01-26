FROM gradle:7.6.0-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build -x test --no-daemon

FROM openjdk:17-slim-bullseye
LABEL maintainer="Ivan Hayel <i.hayel.dev@gmail.com"
EXPOSE 8080
RUN mkdir /eureka-server
ARG JAR_FILE=/home/gradle/src/build/libs/eureka-server-0.0.1.jar
COPY --from=build ${JAR_FILE} /eureka-server/eureka-server.jar
ENTRYPOINT ["java", "-jar", "/eureka-server/eureka-server.jar"]
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY ./api/data ./data
COPY ./api/gradle ./gradle
COPY ./api/src ./src
COPY ./api/gradlew .
COPY ./api/build.gradle .
COPY ./api/settings.gradle .
#COPY ./compose.yml /
RUN ["./gradlew", "build"]
ENTRYPOINT ["java","-jar","./build/libs/ConsultingAPI-0.0.1-SNAPSHOT.jar"]
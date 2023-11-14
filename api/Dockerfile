FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY ./data ./data
COPY ./gradle ./gradle
COPY ./src ./src
COPY ./gradlew .
COPY ./build.gradle .
COPY ./settings.gradle .
#COPY ./compose.yml /
RUN ["./gradlew", "build"]
ENTRYPOINT ["java","-jar","./build/libs/ConsultingAPI-0.0.1-SNAPSHOT.jar"]
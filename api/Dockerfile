FROM gradle:8.4.0-jdk17-alpine
VOLUME /tmp
COPY ./data ./data
COPY ./gradle ./gradle
COPY ./src ./src
COPY ./gradlew .
COPY ./build.gradle .
COPY ./settings.gradle .
#COPY ./compose.yml /
RUN ["gradle", "build"]
ENTRYPOINT ["java","-jar","./build/libs/ConsultingAPI-0.0.1-SNAPSHOT.jar"]
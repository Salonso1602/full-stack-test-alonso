FROM eclipse-temurin:17-jdk
VOLUME /tmp
COPY ./api/build/libs/ConsultingAPI-0.0.1-SNAPSHOT.jar app.jar
#COPY ./compose.yml /
ENTRYPOINT ["java","-jar","/app.jar"]
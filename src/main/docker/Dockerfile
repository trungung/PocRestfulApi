FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD poc-restful-api-0.1.jar app.jar
RUN sh -c 'touch app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
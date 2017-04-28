FROM openjdk:8-jre-alpine
MAINTAINER Andreas Radauer <andreas.radauer@porscheinformatik.at>
LABEL vendor="Porsche Informatik" \
      app="quizmaster"

RUN adduser -D app
COPY target/quizmaster.jar /home/app/app.jar
ENV JAVA_OPTS=
EXPOSE 8080
VOLUME /tmp

USER app
WORKDIR /home/app
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar
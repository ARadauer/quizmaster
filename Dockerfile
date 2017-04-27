FROM java:8

MAINTAINER Andreas Radauer <andreas.radauer@porscheinformatik.at>
LABEL Description="WAD Quizmaster" Vendor="Porsche Informatik" Version="6.0.0"

RUN groupadd -r quiz && useradd -r -g quiz quiz
COPY target/quizmaster-0.0.1-SNAPSHOT.jar /home/quiz/app.war
USER cc

EXPOSE 8080
CMD ["java", "-jar", "/home/quiz/app.war"]

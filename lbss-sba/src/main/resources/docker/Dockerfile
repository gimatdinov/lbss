FROM frolvlad/alpine-oraclejdk8:slim

COPY lbss-sba-*.jar /lbss-sba.jar

RUN mkdir /config
COPY config/application.properties /config
COPY config/logback.xml /config

RUN mkdir /data
RUN mkdir /data/ftp
RUN mkdir /var/log/lbss

ENTRYPOINT ["java", "-Dlogging.config=/config/logback.xml", "-jar", "/lbss-sba.jar"]
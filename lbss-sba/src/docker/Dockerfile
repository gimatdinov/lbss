FROM frolvlad/alpine-oraclejdk8:slim

COPY lbss-sba-*.jar /lbss-sba.jar

RUN mkdir /config
COPY config/application.properties /config
COPY config/logback.xml /config

RUN mkdir /data
RUN mkdir /var/log/lbss

RUN mkdir /data/ftp
COPY data-preset/* /data/ftp/

EXPOSE 2121 30000-31000

ENTRYPOINT ["java", "-Dlogging.config=/config/logback.xml", "-jar", "/lbss-sba.jar"]
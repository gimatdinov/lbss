FROM frolvlad/alpine-oraclejdk8:slim

ADD lbss-sba-0.6.1-SNAPSHOT.jar lbss-sba.jar

RUN sh -c 'touch lbss-sba.jar.jar'

ENTRYPOINT ["java","-jar","lbss-sba.jar"]

EXPOSE 8080 2121
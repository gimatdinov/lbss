FROM frolvlad/alpine-oraclejdk8:slim
ADD lbss-sba-0.6.1-SNAPSHOT.jar lbss.jar
RUN sh -c 'touch /lbss.jar'
RUN mkdir /data
EXPOSE 8080 2121
ENTRYPOINT ["java","-jar","/lbss.jar"]
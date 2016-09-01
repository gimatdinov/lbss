FROM frolvlad/alpine-oraclejdk8:slim
ADD lbss-sba/target/lbss-sba-0.6.0-SNAPSHOT.jar lbss-sba.jar
RUN sh -c 'touch /lbss-sba.jar'
RUN mkdir /data
EXPOSE 8080 2121
ENTRYPOINT ["java","-jar","/lbss-sba.jar"]
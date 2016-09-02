FROM mongo:3.2.9
RUN mkdir /data/preset

COPY start-mongod.sh /
RUN sed -i 's/\r$//g' /start-mongod.sh
RUN chmod +x /start-mongod.sh

COPY import-data.sh /
RUN sed -i 's/\r$//g' /import-data.sh
RUN chmod +x /import-data.sh

COPY data/preset/*.json /data/preset/

ENTRYPOINT ["/start-mongod.sh"]

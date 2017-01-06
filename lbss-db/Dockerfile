FROM mongo:3.2

COPY start-mongod.sh /
RUN sed -i 's/\r$//g' /start-mongod.sh
RUN chmod +x /start-mongod.sh

COPY import-data.sh /
RUN sed -i 's/\r$//g' /import-data.sh
RUN chmod +x /import-data.sh

RUN mkdir /data/preset
COPY data-preset/*.json /data/preset/

EXPOSE 27017

ENTRYPOINT ["/start-mongod.sh"]

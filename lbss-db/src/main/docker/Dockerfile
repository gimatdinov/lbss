FROM mongo:3.2.9
RUN mkdir /data/preset
COPY data/preset/*.json /data/preset
RUN mongod --fork --logpath /var/log/mongodb.log --dbpath /data/db/ \
    && mongoimport --db lbss-members --collection SmevMember --file /data/preset/lbss-members.json \
    && mongod --shutdown
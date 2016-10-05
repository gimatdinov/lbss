#!/bin/sh
mongoimport --db lbss-members --collection SmevMember --file /data/preset/SmevMember.json 
mongoimport --db lbss-messages --collection RequestMessage --file /data/preset/RequestMessage.json
mongoimport --db lbss-messages --collection ResponseMessage --file /data/preset/ResponseMessage.json
# LBSS - (L)oop(B)ack(S)mev(S)tub

Сборка:
``mvn package``

Сборка для Docker:
``mvn -P build-docker-images package``

Запуск:
``java -jar lbss-sba/target/lbss-sba-VERSION.jar``

Запуск в Docker:
``docker-compose up -d``

СМЭВ сервис:
http://__HOST__:8080/lbss-web/SMEVMessageExchangeService?wsdl


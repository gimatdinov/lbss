# LBSS - (L)oop(B)ack(S)mev(S)tub

Сборка:
``mvn package``

Контейнеризация:
``docker build -t gimatdinov/lbss .``

Запуск базы данных:
``docker run --name lbss-db --rm -v /data/lbss-db:/data/db mongo:3.2.9``

Запуск эмулятора:
``docker run --name lbss --rm --link lbss-db:mongo -v /data/lbss-ftp:/data/lbss-ftp gimatdinov/lbss``

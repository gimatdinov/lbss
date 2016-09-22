# LBSS - (L)oop(B)ack(S)mev(S)tub
## Реализовано
* Регистрация участников СМЭВ
* Регистрация видов сведений
* Отправка и прием запросов (SendRequest, GetRequest)
* Отправка и прием ответов (SendResponse, GetResponse)
* Квитирование запросов и ответов (Ack)
* Отправка и прием вложения через встроенный FTP (запускается на порту 2121)
* Сообщение от эмулятора подписываются валидной ЭП-СМЭВ (если в настройках подключен ОТР Криптосервер)
* Асинхронная обработка запросов для сообщений с ссылками на FTP-вложения (Ошибки обработки доступны посредством GetResponse для запросов и GetStatus для ответов)

## Сборка приложения Spring-boot
``mvn package``
## Сборка image для Docker:
``mvn -P build-docker-images package``

## Запуск как приложения Spring Boot
1) Запустите MongoDB (версии 3.2+)

2) ``java -jar lbss-sba/target/lbss-sba-ВЕРСИЯ.jar``

## Запуск в Docker
``docker-compose up -d``

## СМЭВ сервис
http://__HOST__:8080/lbss-web/SMEVMessageExchangeService?wsdl


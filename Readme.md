Курсовой проект «Сервис перевода денег»
=
Описание проэкта
-
Сервис предоставляет интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации.

Заранее подготовленное веб-приложение (FRONT) подключается к разработанному сервису без доработок и использует его
функционал для перевода денег.

Запуск приложения
-

* Запуск используя Docker Compose

> docker-compose up -d

* Сервис работает на порту 5050 для совместимости с приложением "FRONT"

Пример запросов:
-

* Запрос на инициализацию перевода денежных средств:

> Запрос на адрес: http://localhost:5500/transfer
>
>Post Request
>> {  
> > &ensp; “cardFromNumber”: “1234123412341234”, - карта с которой переводят  
> > &ensp; “cardFromCVV”:
> > “123”,&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;-
> > секретный трехзначный код CVV  
> > &ensp; “cardFromValidTill”: “12/26”,&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; -
> > месяц / год обслуживания карты  
> > &ensp; “cardToNumber”: “432143214321”,&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; - карта на которую переводят  
> > &ensp; “amount”: {  
> > &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; “currency”:
> > “RUR”,&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; - валюта перевода   
> > &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; “value”:
> > 100&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; - сумма
> > перевода   
> > }

> Ответ:
>> {  
> > “operationId”:
> >
“1”&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; -
> > номер транзакции  
> > }

* Запрос на подтверждение операции перевода денежных средств:

> Запрос на адрес:  http://localhost:5500/confirmOperation
>
>Post Request
>> {  
> > &ensp; “code”: “0000”,&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp; - код операции  
> > &ensp; “operationId”: “1”&ensp;&ensp;&ensp;&ensp;&ensp; - номер транзакции   
> > }

> Ответ:
>> {  
> > &ensp; “operationId”:“1”&ensp;&ensp;&ensp;&ensp;&ensp; - номер транзакции  
> > }
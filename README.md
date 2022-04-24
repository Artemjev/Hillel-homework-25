***TODO:***
-----------------------------
Develop **API** that handles 3 types of requests:
```
GET / - returns a list of notes
POST / - adds a note
POST /delete - deletes a note by id
```
Information about a note contain:
```
Name
Description
Date and time of creation (filled on the server side with the current time)
```
Store data in the **Postgres** database. Use **JdbcTemplate** class (https://github.com/Artemjev/Hillel-homework-24) to work with the database.

***Задание:***
-----------------------------
Создать **API** обрабатывающая 3 типа запросов:
```
GET / - возвращает список заметок
POST / - добавляет заметку
POST /delete - удаляет заметку по id
```
Данные об одной заметке:
```
Название
Описание
Дата и время создания (заполняется на стороне сервера текущим временем)
```
Данные хранить в бд **Postgres**, для работы с базой использовать класс **JdbcTemplate** (https://github.com/Artemjev/Hillel-homework-24).

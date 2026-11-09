markdown

# Домашнее задание "Написание авто-теста с нуля"
Юлдашева О.В.

## Описание
Окружение: https://wishlist.otus.kartushin.su/login

Проект реализован с использованием: 
* Java 21
* Selenium WebDriver 4
* Junit 5
* Google Guice (DI)
* Maven

## Реализованные сценарии
1.  **Сценарий 1:** Выбор самого дорогого и самого дешёвого подарка.
2.  **Сценарий 2:** Явные ожидания.
3.  **Сценарий 3:** Поиск пользователя и подсветка элемента.

## Как запустить тесты
### 1. Запуск всех тестов:
```bash
mvn clean test
```
### 2. Запуск Сценарий 1 (Выбор самого дорогого и самого дешёвого подарка):
```bash
mvn clean test -Dtest=WishlistTest
```
### 3. Запуск Сценарий 2 (Явные ожидания):
```bash
mvn clean test -Dtest=UsersTest
```
### 4. Запуск Сценарий 3 (Поиск пользователя и подсветка элемента):
```bash
mvn clean test -Dtest=UsersWishlistsTest
```

## Дополнительно
### Проверка стиля кода (Checkstyle):
```bash
mvn checkstyle:check
```
### Поиск багов (SpotBugs):
```bash
mvn spotbugs:check
```
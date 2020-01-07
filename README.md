# VK Observer

VK Observer - это приложение для отслеживания проводимого времени пользователя в соц. сети ВКонтакте.

## Установка / использование

1. получите токен пользователя вк (см Получение токена пользователя)
2. Запишите в файл конфигурации необходимые параметры.
3. Скомпилируйте проект:
        
        mvn compile

4. Запустите программу:
    
        mvn exec:java

## Получение токена пользователя

Перейдите по этой ссылке, заменив APP_ID на id вашего приложения в вк: 

    https://oauth.vk.com/authorize?client_id=APP_ID&redirect_uri=https://oauth.vk.com/blank.html&display=page&response_type=token
    
В адресной строке будет содержаться необходимый токен пользователя (user.code).
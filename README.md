# api.megoru.ru-wrapper

[![JitPack](https://jitpack.io/v/megoRU/api.megoru.ru-wrapper.svg)](https://jitpack.io/#megoRU/api.megoru.ru-wrapper)

Java API-обёртка для сервиса api.megoru.ru, разработанная [@megoRU](https://github.com/megoRU).
Позволяет удобно взаимодействовать с API через Java без необходимости вручную отправлять HTTP-запросы.

---

## 📦 Установка (Maven)

Добавьте репозиторий JitPack и зависимость:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.megoRU</groupId>
    <artifactId>api.megoru.ru-wrapper</artifactId>
    <version>5.1.3</version>
</dependency>
```

---

## 🚀 Пример использования

```java
MegoruAPI megoruAPI = new MegoruAPI.Builder()
        .build();

String word = megoruAPI.getWord(gameWordLanguage).word();

System.out.println(word);
```

---

## 📚 Используемые библиотеки

- Gson
- Apache HttpClient
- JSON-java
- OkHttp

---

## 📄 Лицензия

Данная библиотека распространяется по лицензии MIT.
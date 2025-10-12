# ⚙️ api.megoru.ru Java Wrapper

[api.megoru.ru](https://api.megoru.ru)

---

## 🚀 Пример использования

```java
public static void main(String[] args) {
    MegoruAPI megoruAPI = new MegoruAPI.Builder().build();
    String word = megoruAPI.getWord(gameWordLanguage).word();

    System.out.println(word);
}
```

---

## 📦 Установка через Maven

Добавьте JitPack в репозитории:

```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Затем зависимость:

```xml
<dependency>
  <groupId>com.github.megoRU</groupId>
  <artifactId>api.megoru.ru</artifactId>
  <version>5.1.1</version>
</dependency>
```

📍 [Ссылка на JitPack](https://jitpack.io/#megoRU/api.megoru.ru-wrapper)

---

## ⚙️ Зависимости

* [Gson](https://github.com/google/gson)
* [Apache HttpClient](https://github.com/apache/httpcomponents-client)
* [JSON-java](https://github.com/stleary/JSON-java)
* [OkHttp](https://github.com/square/okhttp)

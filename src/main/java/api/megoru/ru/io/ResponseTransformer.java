package api.megoru.ru.io;

public interface ResponseTransformer<E> {

    E transform(String response);
}
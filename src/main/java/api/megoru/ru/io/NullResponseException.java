package api.megoru.ru.io;

public class NullResponseException extends Exception {

    public NullResponseException() {
        super("response is NULL");
    }
}

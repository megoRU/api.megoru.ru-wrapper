package api.megoru.ru.io;

public class UnsuccessfulHttpException extends Exception {

    private final int code;
    private final String message;

    public UnsuccessfulHttpException(int code, String message) {
        super("The server responded with code: " + code + ", message: " + message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

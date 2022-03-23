package api.megoru.ru.entity;

public class Errors {

    public Integer code;
    public String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Errors code: " + code + "\nErrors message: " + message;
    }
}

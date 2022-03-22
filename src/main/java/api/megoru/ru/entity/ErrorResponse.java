package api.megoru.ru.entity;

public class ErrorResponse {

    Errors error;

    public ErrorResponse(Errors error) {
        this.error = error;
    }

    public Errors getError() {
        return error;
    }
}

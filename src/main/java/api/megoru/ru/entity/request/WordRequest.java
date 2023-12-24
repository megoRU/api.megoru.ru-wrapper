package api.megoru.ru.entity.request;

public class WordRequest extends APIRequest {

    public WordRequest(String host, String language) {
        super(String.format("%s/api/word?language=%s", host, language), RequestMethod.GET);
    }

    public WordRequest(String host, String language, String category) {
        super(String.format("%s/api/word?language=%s&category=%s", host, language, category), RequestMethod.GET);
    }
}
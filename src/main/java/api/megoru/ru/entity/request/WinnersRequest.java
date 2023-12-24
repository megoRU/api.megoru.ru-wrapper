package api.megoru.ru.entity.request;

import api.megoru.ru.entity.Winners;

public class WinnersRequest extends APIRequest {

    public WinnersRequest(String host, Winners winners) {
        super(String.format("%s/api/participants", host), RequestMethod.POST, winners);
    }
}
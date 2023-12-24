package api.megoru.ru.impl;

import api.megoru.ru.utils.JsonUtil;

public interface APIRequestData {

    default String toJson() {
        return JsonUtil.toJson(this);
    }
}
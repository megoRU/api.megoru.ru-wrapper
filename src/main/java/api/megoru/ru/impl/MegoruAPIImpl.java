package api.megoru.ru.impl;

import api.megoru.ru.entity.GameWordLanguage;
import api.megoru.ru.entity.Winners;
import api.megoru.ru.entity.exceptions.UnsuccessfulHttpException;
import api.megoru.ru.entity.request.APIRequest;
import api.megoru.ru.entity.request.WinnersRequest;
import api.megoru.ru.entity.request.WordRequest;
import api.megoru.ru.entity.response.WinnersResponse;
import api.megoru.ru.entity.response.WordResponse;
import api.megoru.ru.utils.JsonUtil;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MegoruAPIImpl implements MegoruAPI {

    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private final boolean devMode;
    private static final String HOST = "https://api.megoru.ru";

    protected MegoruAPIImpl(boolean devMode) {
        this.devMode = devMode;
    }

    @Override
    public List<String> getWinners(Winners winners) throws UnsuccessfulHttpException, IOException {
        return parseResponse(WinnersResponse.class, new WinnersRequest(HOST, winners)).getWinners();
    }

    @Override
    public WordResponse getWord(GameWordLanguage gameWordLanguage) throws UnsuccessfulHttpException, IOException {
        String language = gameWordLanguage.getLanguage();
        String category = gameWordLanguage.getCategory();
        Integer length = gameWordLanguage.getLength();

        if (length != null && category != null) {
            return parseResponse(WordResponse.class, new WordRequest(HOST, language, category, length));
        } else if (length != null) {
            return parseResponse(WordResponse.class, new WordRequest(HOST, language, length));
        } else if (category != null) {
            return parseResponse(WordResponse.class, new WordRequest(HOST, language, category));
        } else {
            return parseResponse(WordResponse.class, new WordRequest(HOST, language));
        }
    }

    private <T extends APIObject> T parseResponse(Class<T> tClass, @NotNull APIRequest apiRequest) throws IOException, UnsuccessfulHttpException {
        Request.Builder requestBuilder = new Request.Builder()
                .url(apiRequest.getUrl())
                .addHeader("Content-Type", "application/json");

        if (apiRequest.getRequestMethod() == APIRequest.RequestMethod.GET) {
            requestBuilder = requestBuilder.get();
        } else if (apiRequest.getRequestMethod() == APIRequest.RequestMethod.POST) {
            if (apiRequest.getData() != null) {
                requestBuilder.post(RequestBody.create(apiRequest.getData().toJson(), MEDIA_TYPE_JSON));
            } else {
                requestBuilder.post(RequestBody.create("{}", MEDIA_TYPE_JSON));
            }
        }

        Request request = requestBuilder.build();

        try (Response response = CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = Objects.requireNonNull(response.body()).string();
                logResponse(responseBody);
                return JsonUtil.fromJson(responseBody, tClass);
            } else {
                throw new UnsuccessfulHttpException(response.code(), response.message());
            }
        }
    }

    private void logResponse(String body) {
        if (!devMode) return;
        System.out.println(body);
    }
}
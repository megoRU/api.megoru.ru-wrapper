package api.megoru.ru.impl;

import api.megoru.ru.entity.*;
import api.megoru.ru.io.DefaultResponseTransformer;
import api.megoru.ru.io.NullResponseException;
import api.megoru.ru.io.ResponseTransformer;
import api.megoru.ru.io.UnsuccessfulHttpException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.HttpUrl;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collection;

public class MegoruAPIImpl implements MegoruAPI {

    private static final HttpUrl baseUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("api.megoru.ru") //vps: 85.192.63.15 //local: 127.0.0.1
            .build();

    private final Gson gson;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    protected MegoruAPIImpl() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public Result setListUsers(Collection<Participants> userList) throws Exception {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("api")
                .addPathSegment("participants")
                .build();
        JSONArray json = new JSONArray(gson.toJson(userList));
        return post(url, json.toString(), new DefaultResponseTransformer<>(Result.class, gson));
    }

    @Override
    public Participants[] getListUsers(String idUserWhoCreateGiveaway, String giveawayId) throws Exception {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("api")
                .addPathSegment("get-participants")
                .build();

        JSONObject json = new JSONObject();
        try {
            json.put("idUserWhoCreateGiveaway", idUserWhoCreateGiveaway);
            json.put("giveawayId", giveawayId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return post(url, json.toString(), new DefaultResponseTransformer<>(Participants[].class, gson));
    }

    @Override
    public String[] setWinners(Winners winners) throws Exception {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("api")
                .addPathSegment("participants")
                .build();

        JSONObject json = new JSONObject(winners);
        return post(url, json.toString(), new DefaultResponseTransformer<>(String[].class, gson));
    }

    @Override
    public String[] reroll(Reroll reroll) throws Exception {
        HttpUrl url = baseUrl.newBuilder()
                .addPathSegment("api")
                .addPathSegment("reroll")
                .build();

        JSONObject json = new JSONObject(reroll);
        return post(url, json.toString(), new DefaultResponseTransformer<>(String[].class, gson));
    }

    @Override
    public Word getWord(GameWordLanguage gameWordLanguage) throws Exception {
        HttpUrl.Builder url = baseUrl.newBuilder()
                .addPathSegment("api")
                .addPathSegment("word")
                .addQueryParameter("language", gameWordLanguage.getLanguage());

        if (gameWordLanguage.getCategory() != null && !gameWordLanguage.getCategory().equals("")) {
            url.addQueryParameter("category", gameWordLanguage.getCategory());
        }

        return get(url.build(), new DefaultResponseTransformer<>(Word.class, gson));
    }

    private <E> E get(HttpUrl url, ResponseTransformer<E> responseTransformer) throws Exception {
        HttpGet request = new HttpGet(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        return execute(request, responseTransformer);
    }

    private <E> E post(HttpUrl url, String jsonBody, ResponseTransformer<E> responseTransformer) throws Exception {
        HttpPost request = new HttpPost(url.uri());
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpEntity stringEntity = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
        request.setEntity(stringEntity);
        return execute(request, responseTransformer);
    }

    private <E> E execute(ClassicHttpRequest request, ResponseTransformer<E> responseTransformer) throws UnsuccessfulHttpException, IOException {
        CloseableHttpResponse response = httpClient.execute(request);

        try {
            // Get HttpResponse Status
            System.out.println("Status: " + response.getCode());
            HttpEntity entity = response.getEntity();

            if (entity == null) {
                throw new NullResponseException();
            }
            String body = EntityUtils.toString(entity);

            System.out.println(body);

            switch (response.getCode()) {
                case 401:
                case 403:
                case 404: {
                    ErrorResponse result = gson.fromJson(body, ErrorResponse.class);
                    throw new UnsuccessfulHttpException(result.getError().getCode(), result.getError().getMessage());
                }
                case 200: {
                    return responseTransformer.transform(body);
                }
                default:
                    throw new UnsuccessfulHttpException(response.getCode(), "API not work, or connection refused");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnsuccessfulHttpException(response.getCode(), "API not work, or connection refused");
        }
    }
}
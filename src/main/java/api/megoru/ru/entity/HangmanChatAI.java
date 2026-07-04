package api.megoru.ru.entity;

import api.megoru.ru.impl.APIObject;
import api.megoru.ru.impl.APIRequestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HangmanChatAI implements APIObject, APIRequestData {

    private String prompt;
    private String language;
}
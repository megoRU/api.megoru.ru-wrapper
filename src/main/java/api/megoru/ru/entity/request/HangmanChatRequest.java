package api.megoru.ru.entity.request;

import api.megoru.ru.entity.HangmanChatAI;

public class HangmanChatRequest extends APIRequest {

    public HangmanChatRequest(String host, HangmanChatAI hangmanChatAI) {
        super(String.format("%s/hangman/chat", host), RequestMethod.POST, hangmanChatAI);
    }
}
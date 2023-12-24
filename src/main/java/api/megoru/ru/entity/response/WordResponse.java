package api.megoru.ru.entity.response;

import api.megoru.ru.impl.APIObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordResponse implements APIObject {

    private String word;
}

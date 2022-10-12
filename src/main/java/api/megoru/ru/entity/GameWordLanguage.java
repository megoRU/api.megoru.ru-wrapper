package api.megoru.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameWordLanguage {

    private String language;
    private String category;

    @Override
    public String toString() {
        return "{" + "\"language\": \"" + language + "\"" + '}';
    }
}

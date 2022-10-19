package api.megoru.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameWordLanguage {

    @NotNull
    private String language;
    private String category;

    @Override
    public String toString() {
        return "{" + "\"language\": \"" + language + "\", \"category\": \"" + category + "\""  + '}';
    }
}

package api.megoru.ru.entity.response;


import api.megoru.ru.impl.APIObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WinnersResponse implements APIObject {

    private List<String> winners;

}
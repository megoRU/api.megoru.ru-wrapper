package api.megoru.ru.entity;

import api.megoru.ru.impl.APIRequestData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Winners implements APIRequestData {

    private Integer n;
    private Integer min;
    private Integer max;
}
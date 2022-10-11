package api.megoru.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reroll {

    public String idUserWhoCreateGiveaway;
    public String giveawayID;
    public Winners winners;
}

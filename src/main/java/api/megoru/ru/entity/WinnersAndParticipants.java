package api.megoru.ru.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WinnersAndParticipants {

    private boolean isUpdate;
    public Collection<? extends Participants> userList;
    public Winners winners;
}

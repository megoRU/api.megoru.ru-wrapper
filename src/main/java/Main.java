import api.megoru.ru.entity.Winners;
import api.megoru.ru.impl.MegoruAPI;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        MegoruAPI megoruAPI = new MegoruAPI.Builder()
                .enableDevMode()
                .build();


        Winners winners = new Winners();
        winners.setN(1);
        winners.setMin(0);
        winners.setMax(10);

        List<String> strings = megoruAPI.getWinners(winners);

        System.out.println(strings.size());
    }
}

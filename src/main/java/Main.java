import api.megoru.ru.MegoruAPI;
import api.megoru.ru.entity.GameWordLanguage;
import api.megoru.ru.entity.Winners;
import api.megoru.ru.entity.Word;
import api.megoru.ru.impl.MegoruAPIImpl;

public class Main {

    public static void main(String[] args) {

        MegoruAPI api = new MegoruAPIImpl("JoUV9CFurkMHrbUtshs7gqvesxjWHvUqdeNatbAqkudwegAsH7hANMCvrAnvkpm3"); //JoUV9CFurkMHrbUtshs7gqvesxjWHvUqdeNatbAqkudwegAsH7hANMCvrAnvkpm3

//
//
//        List<Participants> participantsList = new ArrayList<>();
//
//        participantsList.add(new Participants(
//                "43243234243342",
//                "4323244343234234234432342342",
//                432432432342L,
//                432432432342L,
//                "nickName",
//                "nickNameTag")
//        );
//        participantsList.add(new Participants(
//                "432443243342432f34243342",
//                "4323244343234234234432342342",
//                4324324323442L,
//                43243243432342L,
//                "nickNam33e",
//                "nickN44ameTag")
//        );
//
//
//        Participants[] listUsers = api.getListUsers("250699265389625347", "1203275533941760041");
//
//        for (int i = 0; i < listUsers.length; i++) {
//            System.out.println(listUsers[i].getNickName());
//        }


        Winners winners = new Winners(3, 0, 10);

        String[] strings = api.setWinners(winners);

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }


        Word word = api.getWord(new GameWordLanguage("rus"));

        System.out.println(word.getWord());


    }
}

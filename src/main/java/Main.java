import api.megoru.ru.MegoruAPI;
import api.megoru.ru.entity.bot.botinfo.BotInfo;
import api.megoru.ru.impl.MegoruAPIImpl;

public class Main {

    public static void main(String[] args) {

        MegoruAPI api = new MegoruAPIImpl(
                "580336b2-74da-488a-97c8-b7caaf873221",
                "808277484524011531");


//        505333250810576897 - userid ля поиска его комментариев

//        BotInfo botInfo = api.getBotInformation("808277484524011531").toCompletableFuture().get();
//
//        System.out.println(botInfo.getInformation().toString());


//        api.setStats(191, 1, 350);


        BotInfo bot = api.getBotInformation("808277484524011531");

        System.out.println(bot.getInformation().toString());

//                .whenComplete((botInfo1, throwable) -> {
//                    System.out.println(botInfo1.getInformation().getDevelopers());
//
//                if (throwable != null) {
//                    System.out.println(throwable.getMessage());
//
//                }
//                });

//      DeveloperBots[] developerBots = api.getDeveloperBots("250699265389625347");
//
//
//
//        for (int i = 0; i < developerBots.length; i++) {
//            System.out.println(developerBots[i].toString());
//        }


//        api.setStats(1, 1, 1);
//
//
//
//        api
//                .getBotInformation("808277484524011531")
//                .getLinks()
//                .forEach(System.out::println);
//
//        Comments[] comments = api.getBotComments();
//
//
//        for (int i = 0; i < comments.length; i++) {
//            System.out.println(comments[i].getUserId());
//        }


    }
}

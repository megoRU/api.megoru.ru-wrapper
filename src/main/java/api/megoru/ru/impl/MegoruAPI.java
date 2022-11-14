package api.megoru.ru.impl;

import api.megoru.ru.entity.*;

import java.util.Collection;

public interface MegoruAPI {

    /**
     * @param userList String List<Participants>
     * @return {@link Result}
     */
    Result setListUsers(Collection<Participants> userList) throws Exception;

    /**
     * @param idUserWhoCreateGiveaway String idUserWhoCreateGiveaway
     * @param giveawayId String giveawayId
     * @return {@link Result}
     */
    Participants[] getListUsers(String idUserWhoCreateGiveaway, String giveawayId) throws Exception;

    /**
     * @param winners it`s {@link Winners}
     * @return String[]
     */
    String[] setWinners(Winners winners) throws Exception;

    /**
     * @param reroll it`s {@link Reroll}
     * @return String[]
     */
    String[] reroll(Reroll reroll) throws Exception;

    /**
     * @param gameWordLanguage it`s {@link GameWordLanguage}
     * @return {@link Word}
     */
    Word getWord(GameWordLanguage gameWordLanguage) throws Exception;

    class Builder {
        public MegoruAPI build() {
            return new MegoruAPIImpl();
        }
    }
}
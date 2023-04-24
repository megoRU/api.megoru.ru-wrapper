package api.megoru.ru.impl;

import api.megoru.ru.entity.*;
import api.megoru.ru.io.UnsuccessfulHttpException;

import java.util.Collection;

public interface MegoruAPI {

    /**
     * @param userList String List<Participants>
     * @return {@link Result}
     */
    Result setListUsers(Collection<Participants> userList) throws UnsuccessfulHttpException;

    /**
     * @param idUserWhoCreateGiveaway String idUserWhoCreateGiveaway
     * @param giveawayId String giveawayId
     * @return {@link Result}
     */
    Participants[] getListUsers(String idUserWhoCreateGiveaway, String giveawayId) throws UnsuccessfulHttpException;

    /**
     * @param winners it`s {@link Winners}
     * @return String[]
     */
    String[] setWinners(Winners winners) throws UnsuccessfulHttpException;

    /**
     * @param reroll it`s {@link Reroll}
     * @return String[]
     */
    String[] reroll(Reroll reroll) throws UnsuccessfulHttpException;

    /**
     * @param gameWordLanguage it`s {@link GameWordLanguage}
     * @return {@link Word}
     */
    Word getWord(GameWordLanguage gameWordLanguage) throws Exception;

    class Builder {

        private boolean devMode;

        /**
         * This enables LOGS
         */
        public Builder enableDevMode() {
            this.devMode = true;
            return this;
        }

        public MegoruAPI build() {
            return new MegoruAPIImpl(devMode);
        }
    }
}
package api.megoru.ru;

import api.megoru.ru.entity.*;
import api.megoru.ru.impl.MegoruAPIImpl;
import api.megoru.ru.io.UnsuccessfulHttpException;

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
    Participants[] getListUsers(String idUserWhoCreateGiveaway, String giveawayId) throws UnsuccessfulHttpException;

    /**
     * @param winners it`s {@link Winners}
     * @param
     * @return String[]
     */
    String[] setWinners(Winners winners) throws Exception;


    /**
     * @param gameWordLanguage it`s {@link GameWordLanguage}
     * @param
     * @return {@link Word}
     */
    Word getWord(GameWordLanguage gameWordLanguage) throws Exception;

    class Builder {

        // Required
        private String token = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * @throws IllegalArgumentException if token null
         */
        public MegoruAPI build() {
            if (token == null)
                throw new IllegalArgumentException("The provided token cannot be null!");

            return new MegoruAPIImpl(token);
        }

    }

}

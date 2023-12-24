package api.megoru.ru.impl;

import api.megoru.ru.entity.*;
import api.megoru.ru.entity.exceptions.UnsuccessfulHttpException;
import api.megoru.ru.entity.response.WordResponse;

import java.io.IOException;
import java.util.List;

public interface MegoruAPI {

    /**
     * @param winners it`s {@link Winners}
     * @return List<String>
     */
    List<String> getWinners(Winners winners) throws UnsuccessfulHttpException, IOException;

    /**
     * @param gameWordLanguage it`s {@link GameWordLanguage}
     * @return {@link WordResponse}
     */
    WordResponse getWord(GameWordLanguage gameWordLanguage) throws UnsuccessfulHttpException, IOException;

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
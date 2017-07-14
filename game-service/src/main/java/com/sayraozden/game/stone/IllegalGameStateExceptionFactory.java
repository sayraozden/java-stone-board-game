package com.sayraozden.game.stone;

/**
 * Holds all state exceptions
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
enum IllegalGameStateException {
    ADD_PLAYER {
        @Override
        public IllegalStateException getInstance() {
            return new IllegalStateException("You cannot add player, game has been started or you already added maximum number of players");
        }

    },
    DO_MOVE {
        @Override
        public IllegalStateException getInstance() {
            return new IllegalStateException("You cannot do move before startGame()");
        }
    },
    START_GAME {
        @Override
        public IllegalStateException getInstance() {
            return new IllegalStateException("You cannot start game before add sufficient players");
        }
    },
    FINISH_GAME {
        @Override
        public IllegalStateException getInstance() {
            return new IllegalStateException("You cannot finish fame before you play it");
        }
    };

    public abstract IllegalStateException getInstance();
}

public class IllegalGameStateExceptionFactory {

    /**
     * Constructor.
     *
     * @param exception
     * @return 
     */
    public IllegalStateException getInstance(IllegalGameStateException exception) {
        return exception.getInstance();
    }
}

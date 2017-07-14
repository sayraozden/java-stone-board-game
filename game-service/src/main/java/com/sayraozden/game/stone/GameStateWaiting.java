package com.sayraozden.game.stone;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Waiting: All players have been joined and game is waiting for start command
 *
 * This class models Waiting state of the game and runs appropriate form of
 * methods for Waiting state
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateWaiting implements GameState {

    final static Logger logger = Logger.getLogger(GameStateWaiting.class);

    private final StoneGame context;

    /**
     * Constructor.
     *
     * @param context StoneGame object as state context
     */
    public GameStateWaiting(StoneGame context) {
        this.context = context;
    }

    @Override
    public void addPlayer(int playerID, ArrayList<StonePlayer> playerRepository, int maxPlayers) throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.ADD_PLAYER);
    }

    @Override
    public StonePlayer doMove(StonePlayer player, int pitIndex) throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.DO_MOVE);
    }

    @Override
    public void startGame(ArrayList<StonePlayer> playerRepository) throws IllegalStateException {
        /* Set all players opposite */
        playerRepository.get(0).setOpponent(playerRepository.get(1));
        playerRepository.get(1).setOpponent(playerRepository.get(0));

        this.context.setState(new GameStateStarted(this.context));
    }

    @Override
    public void finishGame() throws IllegalStateException {
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.FINISH_GAME);
    }

}

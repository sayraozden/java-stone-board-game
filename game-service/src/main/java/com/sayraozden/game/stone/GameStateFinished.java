package com.sayraozden.game.stone;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Finished: Game has been finished, no more move can be done
 *
 * This class models Finished state of the game and runs appropriate form of
 * methods for Finished state
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateFinished implements GameState {

    final static Logger logger = Logger.getLogger(GameStateFinished.class);

    private final StoneGame context;

    /**
     * Constructor.
     *
     * @param context StoneGame object as state context
     */
    public GameStateFinished(StoneGame context) {
        this.context = context;
    }

    @Override
    public void addPlayer(int playerID, ArrayList<StonePlayer> playerList, int maxPlayers) throws IllegalStateException {
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
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.DO_MOVE);
    }

    @Override
    public void finishGame() throws IllegalStateException {
        this.context.setState(new GameStateFinished(this.context));
    }

}

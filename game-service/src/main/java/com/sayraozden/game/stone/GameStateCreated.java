package com.sayraozden.game.stone;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Created State: Game has been created and waiting for 2 players to join
 *
 * This class models Created state of the game and runs appropriate form of
 * methods for Created state
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateCreated implements GameState {

    final static Logger logger = Logger.getLogger(GameStateCreated.class);

    private final StoneGame context;

    /**
     * Constructor.
     *
     * @param context StoneGame object as state context
     */
    public GameStateCreated(StoneGame context) {
        this.context = context;
    }

    @Override
    public void addPlayer(int playerID, ArrayList<StonePlayer> playerList, int maxPlayers) throws IllegalStateException {

        logger.info("Add player with id '" + playerID + "'");

        /* Represents how many players have been added */
        int playerCount = playerList.size();

        if (playerCount < maxPlayers) {
            /* Already added players are less than maximum allowed players then create a StonePlayer and add it to conext playerRepository */
            StonePlayer player = new StonePlayer(playerID);
            playerList.add(player);
            logger.debug("Player has been added to playerRepository[" + playerCount + "] Total Players:" + (playerCount + 1));

            if ((playerCount + 1) == maxPlayers) {
                /* Maximum allowed players have been added, then change state to waiting */
                this.context.setState(new GameStateWaiting(this.context));
                logger.debug("Maximum number of player[" + maxPlayers + "] has been added {" + playerList + "}");
            }
        } else {
            /* Maximum number of users have been added */
            throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.ADD_PLAYER);
        }
    }

    @Override
    public StonePlayer doMove(StonePlayer player, int pitIndex) throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.DO_MOVE);
    }

    @Override
    public void startGame(ArrayList<StonePlayer> playerRepository) throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.START_GAME);
    }

    @Override
    public void finishGame() throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.FINISH_GAME);
    }

}

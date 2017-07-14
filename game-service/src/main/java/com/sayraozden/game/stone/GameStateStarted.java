package com.sayraozden.game.stone;

import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Started: Game has been started and also able to get doMove commands
 *
 * This class models Started state of the game and runs appropriate form of
 * methods for Started state
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateStarted implements GameState {

    final static Logger logger = Logger.getLogger(GameStateStarted.class);
    
    private final StoneGame context;

    /**
     * Constructor.
     *
     * @param context StoneGame object as state context
     */
    public GameStateStarted(StoneGame context) {
        this.context = context;
    }

    @Override
    public void addPlayer(int playerID, ArrayList<StonePlayer> playerRepository, int maxPlayers) throws IllegalStateException {
        /* Not allowed for this state */
        throw new IllegalGameStateExceptionFactory().getInstance(IllegalGameStateException.ADD_PLAYER);
    }

    @Override
    public StonePlayer doMove(StonePlayer player, int pitIndex) throws IllegalStateException {

        logger.info("Player {playerID:" + player.getID() + "} did move Pit -> " + pitIndex);

        //Current playing players board
        StoneBoard playerBoard = player.getBoard();

        //Current selected pit to get stones from
        Pit pitToGet = playerBoard.getPit(pitIndex);

        //We will saw stones that we got from pitToGet until reach end of the board
        int pitToSawPointer = pitIndex;
        Pit pitToSaw = null;

        while (!pitToGet.isEmpty() && pitToSawPointer < playerBoard.getSize()) {
            /* While current selected pit has stones, saw them to the pits on the right direction until end of the board */
            pitToSaw = playerBoard.getPit(++pitToSawPointer);
            pitToSaw.addStone(pitToGet.getStone());
        }

        //The opponent player for this turn
        StonePlayer opponent = player.getOpponent();

        if (pitToGet.getCount() == 1) {
            /* Game Rule: After move, Player has only 1 stone in his selected pit, then he'll collect the opponent players all stones at the opposite pit */
            ArrayList<Stone> loserStones = opponent.getBoard().getAllStonesFromPit(pitIndex);
            pitToGet.addAllStones(loserStones);
        }

        if (playerBoard.isEmpty() || opponent.getBoard().isEmpty()) {
            /* Game Rule: One of the players board is empty except BigPit then finish game */
            this.context.setState(new GameStateFinished(this.context));
            this.context.finishGame();
        }

        logger.debug(player.getBoard());

        if (pitToSaw != null
                && pitToSaw.isBigPit()
                && pitToGet.isEmpty()) {
            /* Game Rule: After move, Players last stone went to BigPit then player has another turn, else the opponent has it */
            return player;
        } else {
            return opponent;
        }
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
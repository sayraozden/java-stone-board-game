package com.sayraozden.game.stone;

import com.sayraozden.game.stone.GameStateCreated;
import java.util.ArrayList;
import org.apache.log4j.Logger;

// TODO Write game explanation and rules here
/**
 * This class represents Stone Game
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class StoneGame {

    //Max allowed players for this game 
    private static final int MAX_PLAYERS = 2;

    // Holds all players
    private final ArrayList<StonePlayer> playerRepository;

    // Holds current player which has right to move
    private StonePlayer currentPlayer;

    // Holds current game state
    private GameState currentState;

    final static Logger logger = Logger.getLogger(StoneGame.class);

    /**
     * Constructor.
     */
    public StoneGame() {
        this.setState(new GameStateCreated(this));
        playerRepository = new ArrayList<>();
    }

    /**
     * Sets given state as current game state
     *
     * @param state
     */
    public void setState(GameState state) {
        this.currentState = state;
        logger.info("Game state has been set to " + state.getClass());
    }

    /**
     *
     * @return Current game state
     */
    public String getCurrentState() {
        //TODO Generate an enum to play with states
        return this.currentState.getClass().toString();
    }

    /**
     * Adds new player to game
     *
     * @param playerID
     * @throws IllegalStateException
     */
    public void addPlayer(int playerID) throws IllegalStateException {
        this.currentState.addPlayer(playerID, playerRepository, MAX_PLAYERS);
    }

    /**
     * Does game move
     *
     * @param playerID
     * @param pitIndex
     * @throws IllegalStateException
     */
    public void doMove(int playerID, int pitIndex) throws IllegalStateException {

        if (playerID != currentPlayer.getID()) {
            /* If this turn is not for the aproppriate user then throw exception.  */
            throw new IllegalStateException("It is player{playerID:" + currentPlayer.getID() + "}s turn");
        }

        this.currentPlayer = this.currentState.doMove(this.currentPlayer, pitIndex);
    }

    /**
     * Sets opponent players
     */
    public void startGame() {
        this.currentPlayer = this.playerRepository.get(0);
        this.currentState.startGame(playerRepository);
    }

    /**
     * Counts player points
     */
    public void finishGame() {
        //TODO return result table
        this.currentState.finishGame();
    }

}

package com.sayraozden.game.stone;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.log4j.Logger;

// TODO Write game explanation and rules here
/**
 * This class represents Stone Game
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class StoneGame implements Serializable {

    //Max allowed players for this game 
    private static final int MAX_PLAYERS = 2;

    // Holds all players    
    private final ArrayList<StonePlayer> playerList;

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
        playerList = new ArrayList<>();
    }

    @JsonProperty("players")
    public ArrayList<StonePlayer> getGameBoard() {
        return this.playerList;
    }

    /**
     *
     * @return Next player to move
     */
    public int getNextPlayerID() {
        return this.currentPlayer.getID();
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
     * @return Current game state name
     */
    public String getState() {
        //TODO Do this with enums
        return this.currentState.getClass().getName();
    }

    /**
     * Adds new player to game
     *
     * @param playerID
     * @throws IllegalStateException
     */
    public void addPlayer(int playerID) throws IllegalStateException {
        this.currentState.addPlayer(playerID, playerList, MAX_PLAYERS);
    }

    /**
     * Does game move
     *
     * @param pitIndex
     * @throws IllegalStateException
     */
    public void doMove(int pitIndex) throws IllegalStateException {
        this.currentPlayer = this.currentState.doMove(this.currentPlayer, pitIndex);
    }

    /**
     * Sets opponent players
     */
    public void start() throws IllegalStateException {
        this.currentPlayer = this.playerList.get(0);
        this.currentState.startGame(playerList);
    }

    /**
     * Counts player points
     */
    public void finish() throws IllegalStateException {
        //TODO return result table
        this.currentState.finishGame();
    }

    /**
     *
     * @return Maximum allowed players for this game
     */
    public static int getMaximumAllowedPlayers() {
        return MAX_PLAYERS;
    }

    /**
     *
     * @return String formatted game status
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String yourTurnStatement = "Your turn --> ";

        for (StonePlayer player : this.playerList) {

            if (player.getID() == this.currentPlayer.getID()) {
                sb.append(yourTurnStatement);
            } else {
                sb.append(String.format("%" + yourTurnStatement.length() + "s", " "));
            }

            String line = String.format("Player {%d} %s \n", player.getID(), player.getBoard());
            sb.append(line);
        }

        return sb.toString();
    }

}

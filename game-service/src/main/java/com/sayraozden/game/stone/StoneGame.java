package com.sayraozden.game.stone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public Map<Integer, ArrayList<Pit>> getGameBoard() {
        Map<Integer, ArrayList<Pit>> gameBoard = new HashMap<>();

        for (StonePlayer player : this.playerList) {
            gameBoard.put(player.getID(), player.getBoard().getPitList());
        }

        return gameBoard;
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

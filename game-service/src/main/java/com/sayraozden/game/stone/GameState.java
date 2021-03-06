package com.sayraozden.game.stone;

import java.util.ArrayList;

/**
 * This interface models the game states Principally game has 4 states:
 * <ul>
 * <li>Created: Game has been created and waiting for 2 players to join </li>
 * <li>Waiting: All players have been joined and game is waiting for start
 * command</li>
 * <li>Started: Game has been started and also able to get doMove commands</li>
 * <li>Finished: Game has been finished, no more move can be done</li>
 * </ul>
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public abstract class GameState {

    protected StoneGame context;

    public abstract void addPlayer(int playerID, ArrayList<StonePlayer> playerList, int maxPlayers) throws IllegalStateException;

    /**
     * Does move for given player and given pitIndex
     *
     * @param pitIndex Selected pit to make move
     * @param player StonePlayer object to make this move
     * @return Next player
     * @throws IllegalStateException
     */
    public abstract StonePlayer doMove(StonePlayer player, int pitIndex) throws IllegalStateException;

    /**
     * Sets player opposite players before start the game
     *
     * @param playerRepository
     * @throws IllegalStateException
     */
    public abstract void startGame(ArrayList<StonePlayer> playerRepository) throws IllegalStateException;

    /**
     * Finishes game
     *
     * @throws IllegalStateException
     */
    public abstract void finishGame() throws IllegalStateException;

    /**
     *
     * @return Game status as a console string
     */
    public abstract String getStateOutput();

    /**
     *
     * @return State name as string
     */
    public String getStateName() {
        return this.getClass().getSimpleName();
    }
}

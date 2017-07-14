package com.sayraozden.game.stone;

/**
 * This class represents a game player
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class Player {

    private final int id;

    /**
     * Constructor.
     *
     * @param playerID
     */
    public Player(int playerID) {
        this.id = playerID;
    }

    /**
     *
     * @return Player ID
     */
    public int getID() {
        return this.id;
    }

}

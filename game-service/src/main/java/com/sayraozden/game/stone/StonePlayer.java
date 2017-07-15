package com.sayraozden.game.stone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This class represents Stone game player
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@JsonIgnoreProperties({"opponent"})
public class StonePlayer extends Player {

    //Every StonePlayer has his own board
    private final StoneBoard board;

    //Every StonePlayer has an opponent
    private StonePlayer opponent;

    /**
     * Constructor.
     *
     * @param playerID
     */
    public StonePlayer(int playerID) {
        super(playerID);
        this.board = new StoneBoard();
    }

    /**
     *
     * @return Opponent StonePlayer
     */
    public StonePlayer getOpponent() {
        return this.opponent;
    }

    /**
     * Sets opponent stone player
     *
     * @param opponent
     */
    public void setOpponent(StonePlayer opponent) {
        this.opponent = opponent;
    }

    /**
     *
     * @return StoneBoard of this StonePlayer
     */
    public StoneBoard getBoard() {
        return this.board;
    }

    /**
     *
     * @return Total score of the StonePlayer
     */
    public int getScore() {
        return this.getBoard().getTotalStoneCount();
    }

}

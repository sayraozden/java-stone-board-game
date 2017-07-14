package com.sayraozden.game.stone;

import java.util.ArrayList;

/**
 * This class represents Pit in a board
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class Pit {

    private ArrayList<Stone> stoneList;

    //Is this a normal or big pit
    private boolean isBigPit = false;

    /**
     * Constructor.
     */
    public Pit() {
        stoneList = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param isBigPit Is this a normal or big pit
     */
    public Pit(boolean isBigPit) {
        this();
        this.isBigPit = isBigPit;
    }

    /**
     *
     * @return Is this a normal or big pit
     */
    public boolean isBigPit() {
        return this.isBigPit;
    }

    /**
     * Adds a new stone to pit
     *
     * @param stone Stone object to be added to pit
     */
    public void addStone(Stone stone) {
        this.stoneList.add(stone);
    }

    /**
     * Creates n of stones and puts them in its own TimeComplexity: O(n)
     *
     * @param n
     */
    public void createStone(int n) {
        for (int i = 0; i < n; i++) {
            this.addStone(new Stone());
        }
    }

    /**
     * If pit has at least 1 stone, returns and removes the stone from pit. It
     * is recommended to check isEmpty() before get stone. TimeComplexity: O(1)
     *
     * @return Stone one stone which pit has
     * @throws IndexOutOfBoundsException
     */
    public Stone getStone() throws IndexOutOfBoundsException {
        return this.stoneList.remove(0);
    }

    /**
     * If pit has at least 1 stone, returns and removes all of the stones from
     * TimeComplexity: O(n) pit
     *
     * @return All stones pit has
     */
    public ArrayList<Stone> getAllStones() {
        if (!this.isEmpty()) {
            /* If pit has stone(s) */
            ArrayList<Stone> returnList = (ArrayList<Stone>) this.stoneList.clone();
            this.stoneList.clear();
            return returnList;
        }
        return new ArrayList<Stone>();
    }

    /**
     * Adds given stones to pit
     *
     * @param stones
     */
    public void addAllStones(ArrayList<Stone> stones) {
        stones.forEach((stone) -> {
            this.addStone(stone);
        });
    }

    /*
     * @return Count of the stones TimeComplexity: O(1)
     */
    public int getCount() {
        return this.stoneList.size();
    }

    /**
     * Checks if pit has any stone
     *
     * @return boolean Whether pit has any stone or not TimeComplexity: O(1)
     */
    public boolean isEmpty() {
        return this.stoneList.isEmpty();
    }
}

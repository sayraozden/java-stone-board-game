package com.sayraozden.game.stone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a board which a player own (This is a half board of a
 * game)
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class StoneBoard {

    //Maximum number of pits on the board
    private static final int PIT_COUNT = 7;

    //Maximum number of stones on the board
    private static final int STONE_COUNT = 6;

    //Pit repository
    private final ArrayList<Pit> pitRepository;

    /**
     * Constructor.
     */
    public StoneBoard() {
        this.pitRepository = new ArrayList<>();

        /* Create all stones on the board */
        for (int i = 0; i < PIT_COUNT - 1; i++) {
            Pit pit = new Pit();
            pit.createStone(STONE_COUNT);
            pitRepository.add(pit);
        }

        /* Add a big pit at the most right place of the board */
        pitRepository.add(new Pit(true));
    }

    /**
     *
     * @param pitIndex
     * @return Pit by given pitIndex
     */
    public Pit getPit(int pitIndex) throws IndexOutOfBoundsException {
        return this.pitRepository.get(pitIndex);
    }

    /**
     *
     * @return Board status as a String: TimeComplexity: O(n)
     */
    @Override
    public String toString() {
        String trace = "";
        for (Pit pit : this.pitRepository) {
            trace += "+" + pit.getCount() + "+ ";
        }
        trace += "= " + this.getTotalStoneCount();

        return trace;
    }

    /**
     *
     * @retunr Whether all pits are empty or not (Excluding big pit)
     */
    public boolean isEmpty() {
        for (Pit pit : this.pitRepository) {
            if (!pit.isEmpty() && !pit.isBigPit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return Size of the board including big pit
     */
    public int getSize() {
        return PIT_COUNT;
    }

    /**
     *
     * @deprecated @param fromIndex
     * @return Sub array iterator of pits from the given fromIndex
     */
    public Iterator<Pit> getPitIterator(int fromIndex) {
        return this.getPitIterator(fromIndex, this.pitRepository.size());
    }

    /**
     *
     * @deprecated @param toIndex
     * @param fromIndex
     * @return Sub array iterator of pits from the given fromIndex to toIndex
     */
    public Iterator<Pit> getPitIterator(int fromIndex, int toIndex) {
        return (Iterator<Pit>) pitRepository.subList(fromIndex, pitRepository.size()).iterator();
    }

    /**
     * Creates n Stones at given Pit by pitIndex
     *
     * @param n
     * @param pitIndex
     */
    public void createStoneAtPit(int n, int pitIndex) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!this.getPit(pitIndex).isBigPit()) {
            this.pitRepository.get(pitIndex).createStone(n);
        } else {
            throw new IllegalArgumentException("Stone cannot be created at bigpit");
        }
    }

    /**
     * Adds given stone to given pit by pitIndex
     *
     * @param stone Stone object
     * @param pitIndex
     */
    public void addStoneToPit(Stone stone, int pitIndex) throws IndexOutOfBoundsException {
        this.pitRepository.get(pitIndex).addStone(stone);
    }

    /**
     * Adds all stones to pit by given pitIndex
     *
     * @param stones All stones to be added
     * @param pitIndex PitIndex to add stones
     */
    public void addAllStonesToPit(ArrayList<Stone> stones, int pitIndex) throws IndexOutOfBoundsException {
        this.pitRepository.get(pitIndex).addAllStones(stones);
    }

    /**
     *
     * @param pitIndex
     * @return A stone from Pit by given pitIndex
     */
    public Stone getStoneFromPit(int pitIndex) throws IndexOutOfBoundsException {
        return this.pitRepository.get(pitIndex).getStone();
    }

    /**
     *
     * @param pitIndex
     * @return All stones from Pit by given pitIndex
     */
    public ArrayList<Stone> getAllStonesFromPit(int pitIndex) throws ArrayIndexOutOfBoundsException {
        return this.pitRepository.get(pitIndex).getAllStones();
    }

    /**
     *
     * @return Count of the all stones on Board Pits includes Big Pit
     * TimeComplexity: O(n)
     */
    public int getTotalStoneCount() {
        int sum = 0;

        for (Pit pit : this.pitRepository) {
            sum += pit.getCount();
        }

        return sum;
    }
}

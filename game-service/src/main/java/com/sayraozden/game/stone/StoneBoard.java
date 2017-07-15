package com.sayraozden.game.stone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a board which a player own (This is a half board of a
 * game)
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
@JsonIgnoreProperties({"empty", "size","totalStoneCount"})
public class StoneBoard {

    //Maximum number of pits on the board
    private static final int PIT_COUNT = 7;

    //Maximum number of stones on the board
    private static final int STONE_COUNT = 6;

    //Pit repository
    private final ArrayList<Pit> pitList;

    /**
     * Constructor.
     */
    public StoneBoard() {
        this.pitList = new ArrayList<>();

        /* Create all stones on the board */
        for (int i = 0; i < PIT_COUNT - 1; i++) {
            Pit pit = new Pit(i);
            pit.createStone(STONE_COUNT);
            pitList.add(pit);
        }

        /* Add a big pit at the most right place of the board */
        pitList.add(new Pit(PIT_COUNT - 1, true));
    }

    /**
     *
     * @param pitIndex
     * @return Pit by given pitIndex
     */
    public Pit getPit(int pitIndex) throws IndexOutOfBoundsException {
        return this.pitList.get(pitIndex);
    }

    /**
     *
     * @return Whether all pits are empty or not (Excluding big pit)
     */
    public boolean isEmpty() {
        for (Pit pit : this.pitList) {
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
        return this.getPitIterator(fromIndex, this.pitList.size());
    }

    /**
     *
     * @deprecated @param toIndex
     * @param fromIndex
     * @return Sub array iterator of pits from the given fromIndex to toIndex
     */
    public Iterator<Pit> getPitIterator(int fromIndex, int toIndex) {
        return (Iterator<Pit>) pitList.subList(fromIndex, pitList.size()).iterator();
    }

    /**
     * Creates n Stones at given Pit by pitIndex
     *
     * @param n
     * @param pitIndex
     */
    public void createStoneAtPit(int n, int pitIndex) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!this.getPit(pitIndex).isBigPit()) {
            this.pitList.get(pitIndex).createStone(n);
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
        this.pitList.get(pitIndex).addStone(stone);
    }

    /**
     * Adds all stones to pit by given pitIndex
     *
     * @param stones All stones to be added
     * @param pitIndex PitIndex to add stones
     */
    public void addAllStonesToPit(ArrayList<Stone> stones, int pitIndex) throws IndexOutOfBoundsException {
        this.pitList.get(pitIndex).addAllStones(stones);
    }

    /**
     *
     * @param pitIndex
     * @return A stone from Pit by given pitIndex
     */
    public Stone getStoneFromPit(int pitIndex) throws IndexOutOfBoundsException {
        return this.pitList.get(pitIndex).takeStone();
    }

    /**
     *
     * @param pitIndex
     * @return All stones from Pit by given pitIndex
     */
    public ArrayList<Stone> getAllStonesFromPit(int pitIndex) throws ArrayIndexOutOfBoundsException {
        return this.pitList.get(pitIndex).getAllStones();
    }

    /**
     *
     * @return Unmodifiable pit objects
     */
    @JsonProperty("pits")
    public ArrayList<Pit> getPitList() {
        //TODO think make here read-only
        return this.pitList;
    }

    /**
     *
     * @return Count of the all stones on Board Pits includes Big Pit
     * TimeComplexity: O(n)
     */
    public int getTotalStoneCount() {
        int sum = 0;

        for (Pit pit : this.pitList) {
            sum += pit.getCount();
        }

        return sum;
    }

    /**
     *
     * @return Board status as a String: TimeComplexity: O(n)
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Pit pit : this.pitList) {

            String format = "%02d-> ";

            if (pit.isBigPit()) {
                format = "| %02d | ";
            }

            String pitUnit = String.format(format, pit.getCount());

            sb.append(pitUnit);
        }

        sb.append("= ").append(this.getTotalStoneCount());

        return sb.toString();
    }
}

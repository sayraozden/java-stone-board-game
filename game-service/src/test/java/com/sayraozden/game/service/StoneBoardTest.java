package com.sayraozden.game.service;

import com.sayraozden.game.stone.Stone;
import com.sayraozden.game.stone.Pit;
import com.sayraozden.game.stone.StoneBoard;
import java.util.ArrayList;
import java.util.Random;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class StoneBoardTest {

    private StoneBoard stoneBoard;

    public StoneBoardTest() {
    }

    @Before
    public void setUp() {
        this.stoneBoard = new StoneBoard();
    }

    @After
    public void tearDown() {
        this.stoneBoard = null;
    }

    /**
     * Test of getPit method, of class StoneBoard.
     */
    @Test
    public void testGetPit() {

        int boardSize = this.stoneBoard.getSize();

        for (int i = 0; i < boardSize; i++) {
            assertThat(this.stoneBoard.getPit(i), instanceOf(Pit.class));
        }

    }

    /**
     * Test of getPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetPit_invalidPitIndex() {
        this.stoneBoard.getPit(this.stoneBoard.getSize());
    }

    /**
     * Test of toString method, of class StoneBoard.
     */
    @Test
    public void testToString() {
        //TODO Consider to test this with the dynamic data
        assertThat(this.stoneBoard.toString(), is("+6+ +6+ +6+ +6+ +6+ +6+ +0+ = 36"));
        this.stoneBoard.addStoneToPit(new Stone(), 0);
        assertThat(this.stoneBoard.toString(), is("+7+ +6+ +6+ +6+ +6+ +6+ +0+ = 37"));

    }

    /**
     * Test of isEmpty method, of class StoneBoard.
     */
    @Test
    public void testIsEmpty_empty() {

        for (int i = 0; i < this.stoneBoard.getSize() - 1; i++) {
            this.stoneBoard.getAllStonesFromPit(i);
        }

        assertThat(this.stoneBoard.isEmpty(), is(true));

    }

    /**
     * Test of isEmpty method, of class StoneBoard.
     */
    @Test
    public void testIsEmpty_notEmpty() {
        assertThat(this.stoneBoard.isEmpty(), is(false));
    }

    /**
     * Test of createStoneAtPit method, of class StoneBoard.
     */
    @Test
    public void testCreateStoneAtPit_isNotBigPit() {
        //First index, last index
        int[] index = {0, this.stoneBoard.getSize() - 2};

        for (int i : index) {
            int createdStoneCount = this.getRandomNumber();
            int stoneCountBeforeAdd = this.stoneBoard.getPit(i).getCount();
            this.stoneBoard.createStoneAtPit(createdStoneCount, i);
            assertThat(this.stoneBoard.getPit(i).getCount(), is(createdStoneCount + stoneCountBeforeAdd));
        }
    }

    /**
     * Test of testCreateStoneAtPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testCreateStoneAtPit_invalidPitIndex() {
        this.stoneBoard.createStoneAtPit(1, this.stoneBoard.getSize() + 1);
    }

    /**
     * Test of createStoneAtPit method, of class StoneBoard.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateStoneAtPit_isBigPit() {
        this.stoneBoard.createStoneAtPit(1, this.stoneBoard.getSize() - 1);
    }

    /**
     * Test of addStoneToPit method, of class StoneBoard.
     */
    @Test
    public void testAddStoneToPit() {

        //First index, last index
        int[] index = {0, this.stoneBoard.getSize() - 1};

        for (int i : index) {
            int pitSizeBeforeAdd = this.stoneBoard.getPit(i).getCount();
            this.stoneBoard.addStoneToPit(new Stone(), i);
            assertThat(this.stoneBoard.getPit(i).getCount(), is(pitSizeBeforeAdd + 1));
        }
    }

    /**
     * Test of testAddStoneToPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddStoneToPit_invalidPitIndex() {
        this.stoneBoard.addStoneToPit(new Stone(), this.stoneBoard.getSize() + 1);
    }

    /**
     * Test of addAllStonesToPit method, of class StoneBoard.
     */
    @Test
    public void testAddAllStonesToPit() {
        ArrayList<Stone> allStones = new ArrayList<>();
        int addedStoneCount = this.getRandomNumber();
        int[] index = {0, this.stoneBoard.getSize() - 1};

        for (int i = 0; i < addedStoneCount; i++) {
            allStones.add(new Stone());
        }

        for (int i : index) {
            int beforeAddStoneCount = this.stoneBoard.getPit(i).getCount();
            this.stoneBoard.addAllStonesToPit(allStones, i);
            assertThat(this.stoneBoard.getPit(i).getCount(), is(beforeAddStoneCount + addedStoneCount));
        }
    }

    /**
     * Test of testAddAllStonesToPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllStonesToPit_invalidPitIndex() {
        this.stoneBoard.addAllStonesToPit(new ArrayList<Stone>(), this.stoneBoard.getSize() + 1);
    }

    /**
     * Test of getStoneFromPit method, of class StoneBoard.
     */
    @Test
    public void testGetStoneFromPit() {
        int[] index = {0, this.stoneBoard.getSize() - 1};
        for (int i : index) {
            this.stoneBoard.addStoneToPit(new Stone(), i);
            assertThat(this.stoneBoard.getStoneFromPit(i), instanceOf(Stone.class));
        }
    }

    /**
     * Test of getStoneFromPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetStoneFromPit_invalidPitIndex() {
        this.stoneBoard.getStoneFromPit(this.stoneBoard.getSize() + 1);
    }

    /**
     * Test of getStoneFromPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetStoneFromPit_thereIsNoStone() {
        this.stoneBoard.getAllStonesFromPit(0);
        this.stoneBoard.getStoneFromPit(0);
    }

    /**
     * Test of getAllStonesFromPit method, of class StoneBoard.
     */
    @Test
    public void testGetAllStonesFromPit() {
        try {
            int[] index = {0, this.stoneBoard.getSize() - 1};

            for (int i : index) {
                int stonesBeforeCreate = this.stoneBoard.getPit(i).getCount();
                this.stoneBoard.addStoneToPit(new Stone(), i);

                ArrayList<Stone> allStones = this.stoneBoard.getAllStonesFromPit(i);

                assertThat(allStones, instanceOf(new ArrayList<>().getClass()));
                assertThat(allStones.get(0), instanceOf(Stone.class));
                assertThat(allStones.size(), is(stonesBeforeCreate + 1));
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            fail("Pit didn't return a ArrayList<Stone> " + e);
        }
    }

    /**
     * Test of getAllStonesFromPit method, of class StoneBoard.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetAllStonesFromPit_invalidPitIndex() {
        this.stoneBoard.getAllStonesFromPit(this.stoneBoard.getSize() + 1);
    }

    /**
     * Test of getTotalStoneCount method, of class StoneBoard.
     */
    @Test
    public void testGetTotalStoneCount() {

        //TODO Don't assume default values are true, test dynamically
        int totalStoneCount = 0;

        assertThat(this.stoneBoard.getTotalStoneCount(), is(36));

        this.stoneBoard.addStoneToPit(new Stone(), 1);

        assertThat(this.stoneBoard.getTotalStoneCount(), is(37));

    }

    /**
     *
     * @return Random number between 1 - 99 (Inclusive)
     */
    private int getRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(100) + 1;
    }

}

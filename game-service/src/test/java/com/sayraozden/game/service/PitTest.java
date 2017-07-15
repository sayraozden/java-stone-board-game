package com.sayraozden.game.service;

import com.sayraozden.game.stone.Stone;
import com.sayraozden.game.stone.Pit;
import java.util.ArrayList;
import java.util.Random;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class PitTest {

    private Pit pit;

    public void PitTest() {
    }

    @Before
    public void setUp() {
        this.pit = new Pit(0);
    }

    @After
    public void tearDown() {
        this.pit = null;
    }

    /**
     * Test of addStone method, of class Pit.
     */
    @Test
    public void testAddStone() {

        int addedStoneCount = this.addRandomNumberOfStonesToPit();

        assertThat(this.pit.getCount(), is(addedStoneCount));

        this.pit.addStone(new Stone());

        assertThat(this.pit.getCount(), is(addedStoneCount + 1));
    }

    /**
     * Test of createStone method, of class Pit.
     */
    @Test
    public void testCreateStone() {
    
        int createdStoneCount = this.createRandomNumberOfStonesOnPit();

        assertThat(pit.getCount(), is(createdStoneCount));

    }

    /**
     * Test of getStone method, of class Pit.
     */
    @Test
    public void testGetStone() {
        
        int stoneCount = this.createRandomNumberOfStonesOnPit();

        assertThat(this.pit.takeStone(), instanceOf(Stone.class));
        assertThat(this.pit.getCount(), is(stoneCount - 1));

    }

    /**
     * Test of getStone method, of class Pit.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetStone_withoutStone() {
        this.pit.takeStone();
    }

    /**
     * Test of getAllStones method, of class Pit.
     */
    @Test
    public void testGetAllStones() {

        try {
            int stoneCount = this.createRandomNumberOfStonesOnPit();

            ArrayList<Stone> allStones = this.pit.getAllStones();

            assertThat(allStones, instanceOf(new ArrayList<>().getClass()));
            assertThat(allStones.get(0), instanceOf(Stone.class));
            assertThat(allStones.size(), is(stoneCount));

        } catch (Exception e) {
            fail("Pit didn't return a ArrayList<Stone> " + e);
        }

    }

    /**
     * Test of getAllStones method, of class Pit.
     */
    @Test
    public void testGetAllStones_withoutStone() {
        
        try {
            ArrayList<Stone> allStones;

            allStones = this.pit.getAllStones();
            assertThat(allStones, instanceOf(new ArrayList<>().getClass()));
            assertThat(allStones.size(), is(0));
        } catch (Exception e) {
            fail("Pit didn't return a ArrayList<Stone> " + e);
        }
    }

    /**
     * Test of addAllStones method, of class Pit.
     */
    //@Test
    public void testAddAllStones() {
        
        this.createRandomNumberOfStonesOnPit();

        int randomStoneCount = this.getRandomNumber();
        ArrayList<Stone> allStones = new ArrayList<>();

        for (int i = 0; i < randomStoneCount; i++) {
            allStones.add(new Stone());
        }

        int beforeAddingStoneCount = this.pit.getCount();
        this.pit.addAllStones(allStones);
        int afterAddingStoneCount = this.pit.getCount();

        assertThat(this.pit.getCount(), is(beforeAddingStoneCount + afterAddingStoneCount));

    }

    /**
     * Test of getCount method, of class Pit.
     */
    @Test
    public void testGetCount() {
        
        assertThat(this.pit.getCount(), is(0));

        int addedStoneCount = this.addRandomNumberOfStonesToPit();

        assertThat(this.pit.getCount(), is(addedStoneCount));

    }

    /**
     * Test of isEmpty method, of class Pit.
     */
    @Test
    public void testIsEmpty() {
        
        assertThat(this.pit.isEmpty(), is(true));

        this.pit.addStone(new Stone());

        assertThat(this.pit.isEmpty(), is(false));

    }

    /**
     * Adds random number of stones to Pit
     *
     * @return Number of stones added
     */
    private int addRandomNumberOfStonesToPit() {
        int addedStone = this.getRandomNumber();

        for (int i = 0; i < addedStone; i++) {
            this.pit.addStone(new Stone());
        }

        return addedStone;
    }

    /**
     * Creates random number of stones on Pit
     *
     * @return Number of stones added
     */
    private int createRandomNumberOfStonesOnPit() {
        int createdStone = this.getRandomNumber();
        this.pit.createStone(createdStone);
        return createdStone;
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

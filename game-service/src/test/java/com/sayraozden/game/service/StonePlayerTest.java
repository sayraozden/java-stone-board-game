package com.sayraozden.game.service;

import com.sayraozden.game.stone.StonePlayer;
import java.util.Random;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class StonePlayerTest {

    StonePlayer stonePlayer;

    public StonePlayerTest() {
    }

    @Before
    public void setUp() {
        this.stonePlayer = new StonePlayer(0);
    }

    @After
    public void tearDown() {
        this.stonePlayer = null;
    }

    /**
     * Test of getPoint method, of class StonePlayer.
     */
    @Test
    public void testGetPoint() {

        int addedStoneCount = this.getRandomNumber();
        int countBeforeAddition = this.stonePlayer.getBoard().getTotalStoneCount();
        this.stonePlayer.getBoard().createStoneAtPit(addedStoneCount, 0);
        assertThat(this.stonePlayer.getPoint(), is(addedStoneCount + countBeforeAddition));

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

package com.sayraozden.game.stone;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
//TODO Create a complete test
public class StoneGameTest {

    private StoneGame stoneGame;

    public StoneGameTest() {
    }

    @Before
    public void setUp() {
        this.stoneGame = new StoneGame();
    }

    @After
    public void tearDown() {
        this.stoneGame = null;
    }

    /**
     * Test of addPlayer method, of class StoneGame.
     */
    @Test
    public void testAddPlayer() {
        this.stoneGame.addPlayer(0);
        this.stoneGame.addPlayer(1);

        assertThat(this.stoneGame.getState(), is(GameStateWaiting.class.getSimpleName()));
    }

    /**
     * Test of addPlayer method, of class StoneGame.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer_maximumPlayerAdded() {
        this.stoneGame.addPlayer(0);
        this.stoneGame.addPlayer(1);
        this.stoneGame.addPlayer(2);
    }

    /**
     * Test of doMove method, of class StoneGame.
     */
    @Test
    public void testDoMove() {
        //TODO
    }

    /**
     * Test of doMove method, of class StoneGame.
     */
    @Test
    public void testDoMove_againHisTurn() {
        //TODO
    }

    /**
     * Test of doMove method, of class StoneGame.
     */
    @Test
    public void testDoMove_collectOpposite() {
        //TODO
    }

    /**
     * Test of doMove method, of class StoneGame.
     */
    @Test
    public void testDoMove_moveBigPit() {
        //TODO
    }

    /**
     * Test of doMove method, of class StoneGame.
     */
    @Test
    public void testDoMove_finishGame() {
        //TODO
    }

    /**
     * Test of startGame method, of class StoneGame.
     */
    @Test
    public void testStartGame() {
        this.stoneGame.addPlayer(0);
        this.stoneGame.addPlayer(1);
        this.stoneGame.start();

        assertThat(this.stoneGame.getState(), is(GameStateStarted.class.getSimpleName()));
    }

    /**
     * Test of finishGame method, of class StoneGame.
     */
    @Test
    public void testFinishGame() {
        //TODO
    }

}

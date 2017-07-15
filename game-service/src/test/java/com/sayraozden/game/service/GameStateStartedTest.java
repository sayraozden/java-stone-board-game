package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.StonePlayer;
import com.sayraozden.game.stone.GameState;
import com.sayraozden.game.stone.GameStateStarted;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateStartedTest {

    private GameState state = new GameStateStarted(new StoneGame());

    /**
     * Test of addPlayer method, of class GameStateStarted.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer() {
        this.state.addPlayer(0, new ArrayList<StonePlayer>(), 0);
    }

    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_sawStone() {
        //TODO Finish doMove test
    }
    
    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_moveAgain() {
        //TODO Finish doMove test
    }
    
    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_collectStones() {
        //TODO Finish doMove test
    }
    
    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_gameFinished() {
        //TODO Finish doMove test
    }

    /**
     * Test of startGame method, of class GameStateStarted.
     */
    @Test(expected = IllegalStateException.class)
    public void testStartGame() {
        this.state.startGame(new ArrayList<StonePlayer>());
    }

    /**
     * Test of finishGame method, of class GameStateStarted.
     */
    @Test(expected = IllegalStateException.class)
    public void testFinishGame() {
        this.state.finishGame();
    }

}

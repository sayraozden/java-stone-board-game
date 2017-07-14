package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.GameStateFinished;
import com.sayraozden.game.stone.GameState;
import org.junit.Test;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateFinishedTest {
    
    private GameState state = new GameStateFinished(new StoneGame());
    
    public GameStateFinishedTest() {
    }    

    /**
     * Test of addPlayer method, of class GameStateFinished.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer() {
        
    }

    /**
     * Test of doMove method, of class GameStateFinished.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoMove() {
        
    }

    /**
     * Test of startGame method, of class GameStateFinished.
     */
    @Test
    public void testStartGame() {
       
    }

    /**
     * Test of finishGame method, of class GameStateFinished.
     */
    @Test
    public void testFinishGame() {
        
    }
    
}

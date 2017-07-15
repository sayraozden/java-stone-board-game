package com.sayraozden.game.stone;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.GameStateFinished;
import com.sayraozden.game.stone.GameState;
import com.sayraozden.game.stone.StonePlayer;
import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateFinishedTest {

    private final GameState state = new GameStateFinished(new StoneGame());

    public GameStateFinishedTest() {
    }

    /**
     * Test of addPlayer method, of class GameStateFinished.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer() {
        this.state.addPlayer(1, new ArrayList<StonePlayer>(), 1);
    }

    /**
     * Test of doMove method, of class GameStateFinished.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoMove() {
        this.state.doMove(new StonePlayer(0), 0);
    }

    /**
     * Test of startGame method, of class GameStateFinished.
     */
    @Test(expected = IllegalStateException.class)
    public void testStartGame() {
        this.state.startGame(new ArrayList<StonePlayer>());
    }

    /**
     * Test of finishGame method, of class GameStateFinished.
     */
    @Test
    public void testFinishGame() {
        //TODO Complete finishGame test method
    }

}

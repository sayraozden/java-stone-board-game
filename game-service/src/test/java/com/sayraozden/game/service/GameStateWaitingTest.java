package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.StonePlayer;
import com.sayraozden.game.stone.GameStateWaiting;
import com.sayraozden.game.stone.GameState;
import java.util.ArrayList;
import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateWaitingTest {

    private GameState state = new GameStateWaiting(new StoneGame());

    public GameStateWaitingTest() {
    }

    /**
     * Test of addPlayer method, of class GameStateWaiting.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer() {
        this.state.addPlayer(0, new ArrayList<StonePlayer>(), 0);
    }

    /**
     * Test of doMove method, of class GameStateWaiting.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoMove() {
        this.state.doMove(new StonePlayer(0), 0);
    }

    /**
     * Test of startGame method, of class GameStateWaiting.
     */
    @Test
    public void testStartGame() {
        ArrayList<StonePlayer> playerRepository = new ArrayList<>(Arrays.asList(
                new StonePlayer(1),
                new StonePlayer(2)
        ));
        this.state.startGame(playerRepository);
        assertThat(playerRepository.get(0).getOpponent().getID(), is(2));
        assertThat(playerRepository.get(1).getOpponent().getID(), is(1));
    }

    /**
     * Test of finishGame method, of class GameStateWaiting.
     */
    @Test(expected = IllegalStateException.class)
    public void testFinishGame() {
        this.state.finishGame();
    }

}

package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.GameState;
import com.sayraozden.game.stone.GameStateCreated;
import com.sayraozden.game.stone.StonePlayer;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author Fuat Sayra OZDEN <sayra@sayraozden.com>
 */
public class GameStateCreatedTest {

    private final GameState state = new GameStateCreated(new StoneGame());

    public GameStateCreatedTest() {
    }

    /**
     * Test of addPlayer method, of class GameStateCreated.
     */
    @Test
    public void testAddPlayer() {
        int maximumAllowedPlayers = StoneGame.getMaximumAllowedPlayers();
        ArrayList<StonePlayer> playerRepository = new ArrayList<>();

        for (int i = 0; i < maximumAllowedPlayers; i++) {
            this.state.addPlayer(i, playerRepository, maximumAllowedPlayers);
            assertThat(playerRepository.get(i), instanceOf(StonePlayer.class));
        }

        assertThat(playerRepository.size(), is(maximumAllowedPlayers));
    }

    /**
     * Test of addPlayer method, of class GameStateCreated.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddPlayer_maximumPlayerAlreadyAdded() {
        int maximumAllowedPlayers = StoneGame.getMaximumAllowedPlayers();
        ArrayList<StonePlayer> playerRepository = new ArrayList<>();

        for (int i = 0; i <= maximumAllowedPlayers; i++) {
            this.state.addPlayer(i, playerRepository, maximumAllowedPlayers);
        }
    }

    /**
     * Test of doMove method, of class GameStateCreated.
     */
    @Test(expected = IllegalStateException.class)
    public void testDoMove() {
        this.state.doMove(new StonePlayer(0), 0);
    }

    /**
     * Test of startGame method, of class GameStateCreated.
     */
    @Test(expected = IllegalStateException.class)
    public void testStartGame() {
        this.state.startGame(new ArrayList<StonePlayer>());
    }

    /**
     * Test of finishGame method, of class GameStateCreated.
     */
    @Test(expected = IllegalStateException.class)
    public void testFinishGame() {
        this.state.finishGame();
    }

}

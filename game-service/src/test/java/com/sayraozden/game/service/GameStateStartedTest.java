package com.sayraozden.game.service;

import com.sayraozden.game.stone.StoneGame;
import com.sayraozden.game.stone.StonePlayer;
import com.sayraozden.game.stone.GameState;
import com.sayraozden.game.stone.GameStateStarted;
import com.sayraozden.game.stone.Pit;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
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

        StonePlayer player = new StonePlayer(0);
        player.setOpponent(new StonePlayer(1));

        int totalStoneCountBeforeSaw = player.getBoard().getTotalStoneCount();

        for (int i = 0; i < player.getBoard().getSize(); i++) {

            Pit pitToGet = player.getBoard().getPit(i);
            int pitStoneCountBeforeSaw = pitToGet.getCount();
            int boardSize = player.getBoard().getSize() - 1;
            int[] pitCountsBeforeSaw = new int[boardSize];

            for (int j = i + 1; j < boardSize; j++) {
                int pitCount = player.getBoard().getPit(j).getCount();
                pitCountsBeforeSaw[j] = pitCount;
            }

            this.state.doMove(player, i);

            assertThat(player.getBoard().getTotalStoneCount(), is(totalStoneCountBeforeSaw));
            assertThat(pitToGet.getCount(), is(pitStoneCountBeforeSaw - (boardSize - i)));
            assertThat(pitToGet.getCount(), greaterThanOrEqualTo(0));

            for (int j = i + 1; j < boardSize; j++) {
                int pitCount = player.getBoard().getPit(j).getCount();
                assertThat(pitCount, is(pitCountsBeforeSaw[j] + 1));
            }
        }

    }

    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_moveAgain() {

        //Assume pits have 6 stones on start and board size is 6
        StonePlayer player = new StonePlayer(0);
        player.setOpponent(new StonePlayer(1));

        StonePlayer nextPlayer = this.state.doMove(player, 0);

        assertThat(player.getBoard().getPit(0).getCount(), is(0));
        assertThat(nextPlayer.getID(), is(0));

    }

    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_collectStones() {
        
        //Assume pits have 6 stones on start
        StonePlayer player = new StonePlayer(0);
        player.setOpponent(new StonePlayer(1));

        StonePlayer nextPlayer = this.state.doMove(player, 1);

        assertThat(player.getBoard().getPit(1).getCount(), is(7));
        
    }

    /**
     * Test of doMove method, of class GameStateStarted.
     */
    @Test
    public void testDoMove_gameFinished() {
        
        //TODO complete gameFinished test
        
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

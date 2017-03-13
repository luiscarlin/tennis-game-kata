package com.tennisgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private Player underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Player();
    }

    @Test
    public void PlayerNameCanBeSet() throws Exception {
        underTest.setName("Rita");
        assertThat(underTest.getName(), is("Rita"));
    }

    @Test
    public void PlayerKnowsTotalGamesLostAndCanIncrement() throws Exception {
        underTest.incrementNumGamesLost();
        assertThat(underTest.getNumGamesLost(), is(1));
    }

    @Test
    public void PlayerKnowsTotalGamesWonAndCanIncrement() throws Exception {
        underTest.incrementNumGamesWon();
        assertThat(underTest.getNumGamesWon(), is(1));
    }

    @Test
    public void PlayersCanBeCompared() throws Exception {
        underTest.setName("player1");

        Player playerTwo = new Player();
        playerTwo.setName("player2");

        assertThat(underTest.equals(playerTwo), is(false));
        assertTrue(underTest.hashCode() != playerTwo.hashCode());
    }
}

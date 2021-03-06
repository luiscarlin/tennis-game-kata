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
        underTest = new Player("Carl");
    }

    @Test
    public void playerNameCanBeSet() throws Exception {
        underTest.setName("Rita");
        assertThat(underTest.getName(), is("Rita"));
    }

    @Test
    public void playerNameCanBeSetInConstructor() throws Exception {
        String name = "Rita";
        Player player = new Player(name);
        assertThat(player.getName(), is(name));
    }

    @Test
    public void playerKnowsTotalGamesLostAndCanIncrement() throws Exception {
        underTest.incrementNumGamesLost();
        assertThat(underTest.getNumGamesLost(), is(1));
    }

    @Test
    public void playerKnowsTotalGamesWonAndCanIncrement() throws Exception {
        underTest.incrementNumGamesWon();
        assertThat(underTest.getNumGamesWon(), is(1));
    }

    @Test
    public void playersCanBeCompared() throws Exception {
        underTest.setName("player1");

        Player playerTwo = new Player("player2");

        assertThat(underTest.equals(playerTwo), is(false));
        assertTrue(underTest.hashCode() != playerTwo.hashCode());
    }
}

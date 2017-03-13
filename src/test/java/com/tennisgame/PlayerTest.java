package com.tennisgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void PlayerKnowsTotalGamesLost() throws Exception {
        underTest.incrementNumGamesLost();
        assertThat(underTest.getNumGamesLost(), is(1));
    }

    @Test
    public void PlayerKnowsTotalGamesWon() throws Exception {
        underTest.incrementNumGamesWon();
        assertThat(underTest.getNumGamesWon(), is(1));
    }
}

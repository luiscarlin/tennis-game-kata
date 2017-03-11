package com.tennisgame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private Player underTest;

    @Mock
    TennisGame tennisGame;

    @Before
    public void setUp() throws Exception {
        underTest = new Player();
    }

    @Test
    public void PlayerNameCanBeSet() throws Exception {
        Player underTest = new Player();
        underTest.setName("Rita");
        assertThat(underTest.getName(), is("Rita"));
    }

    @Test
    public void PlayerGameCanBeSet() throws Exception {
        Player underTest = new Player();
        underTest.setGame(tennisGame);
        assertThat(underTest.getGame(), is(tennisGame));
    }

    @Test(expected = IllegalStateException.class)
    public void ShouldThrowExceptionIfAskedForGameScoreWithoutAGame() throws Exception {
        Player underTest = new Player();
        underTest.getCurrentScore();
    }
}

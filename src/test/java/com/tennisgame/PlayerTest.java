package com.tennisgame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Mock private TennisGame tennisGame;

    @InjectMocks private Player underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Player();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void PlayerNameCanBeSet() throws Exception {
        underTest.setName("Rita");
        assertThat(underTest.getName(), is("Rita"));
    }

    @Test
    public void PlayerGameCanBeSet() throws Exception {
        underTest.setGame(tennisGame);
        assertThat(underTest.getGame(), is(tennisGame));
    }

    @Test(expected = IllegalStateException.class)
    public void ShouldThrowExceptionIfAskedForGameScoreWithoutAGame() throws Exception {
        Player player = new Player();
        player.getCurrentScore();
    }

    @Test
    public void ShouldReturnPlayerScore() throws Exception {
        underTest.setGame(tennisGame);
        assertThat(underTest.getCurrentScore(), is(0));
    }
}

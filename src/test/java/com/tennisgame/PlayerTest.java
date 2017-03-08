package com.tennisgame;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    @Mock TennisGame tennisGame;

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
}

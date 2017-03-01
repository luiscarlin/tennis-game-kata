package com.tennisgame;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    TennisGame underTest;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        underTest = new TennisGame();
    }

    @Test
    public void aGameWaitsForPlayersToStart() throws Exception {
        String state = underTest.getState();
        assertThat(state, is("Waiting for players"));
    }

    @Test
    public void aGameShouldNotStartWithoutPlayers() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(containsString("cannot start without players"));
        underTest.start();
    }
}

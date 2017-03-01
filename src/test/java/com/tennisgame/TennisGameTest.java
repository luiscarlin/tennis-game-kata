package com.tennisgame;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    private TennisGame underTest;
    private final String WAITING_FOR_PLAYERS_STATE = "Waiting for players";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        underTest = new TennisGame();
    }

    @Test
    public void aGameWaitsForPlayersToStart() throws Exception {
        String state = underTest.getState();
        assertThat(state, is(WAITING_FOR_PLAYERS_STATE));
    }

    @Test(expected = IllegalStateException.class)
    public void aGameShouldNotStartWithoutPlayers() throws Exception {
        underTest.start();
    }

    @Test(expected = IllegalStateException.class)
    public void aGameShouldNotStartWithOnePlayer() throws Exception {
        underTest.addPlayer("Rita");
        underTest.start();
    }

    @Test
    public void aGameAcceptsAPlayerAndWaitsForSecondPlayerToJoin() throws Exception {
        underTest.addPlayer("Rita");
        String state = underTest.getState();
        assertThat(state, is(WAITING_FOR_PLAYERS_STATE));
    }

    @Test
    public void aGameAcceptsTwoPlayersAndWaitsToStart() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        String state = underTest.getState();
        assertThat(state, is("Ready to start"));
    }
}

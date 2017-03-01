package com.tennisgame;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    private TennisGame underTest;
    private final String WAITING_FOR_PLAYERS_STATE = "Waiting for players";
    private final String EXCEPTION_CANNOT_START_WITHOUT_PLAYERS = "The game cannot start without players";

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

    @Test
    public void aGameShouldNotStartWithoutPlayers() throws Exception {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage(containsString(EXCEPTION_CANNOT_START_WITHOUT_PLAYERS));
        underTest.start();
    }

    @Test
    public void aGameAcceptsAPlayerAndWaitsForSecondPlayerToJoin() throws Exception {
        underTest.addPlayer("Rita");
        String state = underTest.getState();
        assertThat(state, is(WAITING_FOR_PLAYERS_STATE));
    }
}

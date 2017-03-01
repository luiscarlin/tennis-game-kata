package com.tennisgame;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {
    @Test
    public void aGameWaitsForPlayersToStart() throws Exception {
        TennisGame underTest = new TennisGame();
        String state = underTest.getState();
        assertThat(state, is("Waiting for players"));
    }
}

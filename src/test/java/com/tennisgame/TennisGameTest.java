package com.tennisgame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    private TennisGame underTest;
    private final String WAITING_FOR_PLAYERS_STATE = "Waiting for players";
    private final String READY_TO_START_STATE = "Ready to start";
    private final String GAME_STARTED_STATE = "Game started";

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
        assertThat(state, is(READY_TO_START_STATE));
    }

    @Test
    public void aGameStartsWithTwoPlayers() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        String state = underTest.getState();
        assertThat(state, is(GAME_STARTED_STATE));
    }

    @Test
    public void aGameStartsWithScoreLoveLove() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        String score = underTest.getScore();
        assertThat(score, is("love:love"));
    }

    @Test
    public void fifteenShouldBeDescriptionWhenPlayer1Scores1() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        String score = underTest.getScore();
        assertThat(score, is("fifteen:love"));
    }

    @Test
    public void fifteenShouldBeDescriptionWhenPlayer2Scores1() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerTwoWinBall();
        String score = underTest.getScore();
        assertThat(score, is("love:fifteen"));
    }

    @Test
    public void thirtyShouldBeDescriptionWhenPlayer1Scores2() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        String score = underTest.getScore();
        assertThat(score, is("thirty:love"));
    }

    @Test
    public void thirtyShouldBeDescriptionWhenPlayer2Scores2() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        String score = underTest.getScore();
        assertThat(score, is("love:thirty"));
    }

    @Test
    public void fortyShouldBeDescriptionWhenPlayer1Scores3() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        String score = underTest.getScore();
        assertThat(score, is("forty:love"));
    }

    @Test
    public void fortyShouldBeDescriptionWhenPlayer2Scores3() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        String score = underTest.getScore();
        assertThat(score, is("love:forty"));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastBothPlayersHaveScoredThreePointsAndTheyHaveSameScore() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();

        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();

        String score = underTest.getScore();
        assertThat(score, is("deuce"));
    }
}

package com.tennisgame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TennisGameTest {

    @InjectMocks private TennisGame underTest;
    @Mock private Player playerOne;
    @Mock private Player playerTwo;

    private final String WAITING_FOR_PLAYERS_STATE = "Waiting for Players";
    private final String READY_TO_START_STATE = "Ready to Start";
    private final String GAME_STARTED_STATE = "Game Started";

    @Before
    public void setUp() throws Exception {
        underTest = new TennisGame();
        MockitoAnnotations.initMocks(this);
        playerOne.setName("Rita");
        playerTwo.setName("Carl");
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
        Player newPlayer = new Player("Rita");

        underTest.addPlayer(newPlayer);
        underTest.start();
    }

    @Test
    public void aGameAcceptsAPlayerAndWaitsForSecondPlayerToJoin() throws Exception {
        Player newPlayer = new Player("Rita");

        underTest.addPlayer(newPlayer);
        String state = underTest.getState();
        assertThat(state, is(WAITING_FOR_PLAYERS_STATE));
    }

    @Test
    public void aGameAcceptsTwoPlayersAndWaitsToStart() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);

        String state = underTest.getState();
        assertThat(state, is(READY_TO_START_STATE));
    }

    @Test
    public void aGameStartsWithTwoPlayers() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);

        underTest.start();
        String state = underTest.getState();
        assertThat(state, is(GAME_STARTED_STATE));
    }

    @Test
    public void aGameStartsWithScoreZeroZero() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);

        underTest.start();
        assertThat(underTest.getScore(playerOne), is(0));
        assertThat(underTest.getScore(playerTwo), is(0));
    }

    @Test
    public void loveShouldBeDescriptionForScore0() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);

        underTest.start();
        assertThat(underTest.getScoreDescription(playerOne), is("love"));
    }

    @Test
    public void playerCanWinBallAndIncreaseScore() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);

        underTest.start();

        assertThat(underTest.getScore(playerOne), is(0));

        underTest.winBall(playerOne);
        assertThat(underTest.getScore(playerOne), is(1));
    }

    /*
    @Test
    public void fifteenShouldBeDescriptionWhenPlayer1Scores1() throws Exception {
        underTest.addPlayer(playerOne);
        underTest.addPlayer(playerTwo);
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
    public void deuceShouldBeDescriptionWhenAtLeastBothPlayersHaveScoredThreePointsAndPlayerOneMatchesScore() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();

        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();

        underTest.playerOneWinBall();

        String score = underTest.getScore();
        assertThat(score, is("deuce"));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastBothPlayersHaveScoredThreePointsAndPlayerTwoMatchesScore() throws Exception {
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

    @Test
    public void advantageShouldBeDescriptionWhenAtLeastBothPlayersHaveScoredThreePointsAndPlayerOneHasOneExtraPoint() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();

        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();

        underTest.playerOneWinBall();

        String score = underTest.getScore();
        assertThat(score, is("advantage Rita"));
    }

    @Test
    public void advantageShouldBeDescriptionWhenAtLeastBothPlayersHaveScoredThreePointsAndPlayerTwoHasOneExtraPoint() throws Exception {
        underTest.addPlayer("Rita");
        underTest.addPlayer("Carl");
        underTest.start();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();
        underTest.playerOneWinBall();

        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();
        underTest.playerTwoWinBall();

        String score = underTest.getScore();
        assertThat(score, is("advantage Carl"));
    }*/
}

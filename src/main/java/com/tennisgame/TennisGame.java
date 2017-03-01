package com.tennisgame;

import java.util.ArrayList;
import java.util.List;

public class TennisGame {

    private List<String> players;
    private String state;
    private String score;

    TennisGame() {
        players = new ArrayList<String>();
        state = "Waiting for players";
    }

    public String getState() {
        return state;
    }

    public void start() throws IllegalStateException {
        if (state == "Ready to start") {
            state  = "Game started";
            score = "love:love";
        }
        else {
            throw new IllegalStateException("The game cannot start without two players");
        }
    }

    public void addPlayer(String playerName) {
        players.add(playerName);

        if(players.size() == 2) {
            state = "Ready to start";
        }
    }

    public String getScore() {
        return score;
    }

    public void playerOneWinBall() {
        score = "fifteen:love";
    }
}

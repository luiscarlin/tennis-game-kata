package com.tennisgame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TennisGame {

    private enum State {
        WAITING_FOR_PLAYERS ("Waiting for Players"),
        READY_TO_START      ("Ready to Start"),
        GAME_STARTED        ("Game Started");

        private final String state;

        State(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

    }
    private final List<String> DESCRIPTIONS = Arrays.asList("love", "fifteen", "thirty", "forty");
    private Map<Player, Integer> players;

    private State state;

    TennisGame() {
        players = new HashMap<Player, Integer>();
        state = State.WAITING_FOR_PLAYERS;
    }

    public String getState() {
        return state.getState();
    }

    public void start() throws IllegalStateException {
        if (state == State.READY_TO_START) {
            state  = State.GAME_STARTED;
        }
        else {
            throw new IllegalStateException("The game cannot start without two players");
        }
    }

    public void addPlayer(Player player) {
        players.put(player, 0);

        if(players.size() == 2) {
            state = State.READY_TO_START;
        }
    }

    public Integer getScore(Player player) {
        return players.get(player);
    }

    public String getScoreDescription(Player player) {
        int score = players.get(player);
        return DESCRIPTIONS.get(score);
    }

    public void winBall(Player player) {
        int score = players.get(player);
        players.put(player, score + 1);
    }
}

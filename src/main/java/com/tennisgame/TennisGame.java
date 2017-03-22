package com.tennisgame;

import java.util.*;

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
    private Map<Player, Integer> scores;
    private List<Player> players;

    private State state;

    TennisGame() {
        scores = new HashMap<Player, Integer>();
        players = new ArrayList<Player>();
        state = State.WAITING_FOR_PLAYERS;
    }

    public String getState() {
        return state.getState();
    }

    public void start() throws IllegalStateException {
        if (state == State.READY_TO_START) {
            scores.put(players.get(0), 0);
            scores.put(players.get(1), 0);

            state  = State.GAME_STARTED;
        }
        else {
            throw new IllegalStateException("The game cannot start without two scores");
        }
    }

    public void addPlayer(Player player) {
        players.add(player);

        if (players.size() == 2) {
            state = State.READY_TO_START;
        }
    }

    public Integer getScore(Player player) {
        return scores.get(player);
    }

    public String getScoreDescription(Player player) {
        int score = scores.get(player);
        return DESCRIPTIONS.get(score);
    }

    public void winBall(Player player) {
        int score = scores.get(player);
        scores.put(player, score + 1);
    }
}

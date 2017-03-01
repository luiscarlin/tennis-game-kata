package com.tennisgame;

public class TennisGame {
    public String getState() {
        return "Waiting for players";
    }

    public void start() throws IllegalStateException {
        throw new IllegalStateException("The game cannot start without players");
    }
}

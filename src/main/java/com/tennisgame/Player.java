package com.tennisgame;

public class Player {
    private String name;
    private TennisGame game;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGame(TennisGame game) {
        this.game = game;
    }

    public TennisGame getGame() {
        return game;
    }
}
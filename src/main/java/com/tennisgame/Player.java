package com.tennisgame;

public class Player {
    private String name;
    private int numGamesLost;
    private int numGamesWon;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumGamesLost() {
        return numGamesLost;
    }

    public void incrementNumGamesLost() {
        numGamesLost++;
    }

    public int getNumGamesWon() {
        return numGamesWon;
    }

    public void incrementNumGamesWon() {
        numGamesWon++;
    }
}

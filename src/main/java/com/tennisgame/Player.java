package com.tennisgame;

public class Player {
    private String name;
    private int numGamesLost;

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
}

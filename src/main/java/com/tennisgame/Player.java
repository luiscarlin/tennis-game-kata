package com.tennisgame;

public class Player {
    private String name;
    private int numGamesLost;
    private int numGamesWon;

    Player(String name) {
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (numGamesLost != player.numGamesLost) return false;
        if (numGamesWon != player.numGamesWon) return false;
        return name != null ? name.equals(player.name) : player.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + numGamesLost;
        result = 31 * result + numGamesWon;
        return result;
    }
}

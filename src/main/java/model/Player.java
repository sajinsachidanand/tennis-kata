package model;

import service.Scores;

public class Player implements Scores {
    private int score;

    private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void add() {
        this.score++;
    }
}

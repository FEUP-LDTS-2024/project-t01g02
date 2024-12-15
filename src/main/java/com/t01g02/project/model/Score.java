package com.t01g02.project.model;

public class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void incrementScore(int increment){
        this.score += increment;
    } // no final increment score mais seconds
}

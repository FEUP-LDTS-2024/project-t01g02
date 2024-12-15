package com.t01g02.project.controller;


import com.t01g02.project.model.Score;

import java.util.Locale;

public class ScoreController extends KittyObserver {
    private Score score;
    private boolean hasStarBeenPickedUp = false;


    public ScoreController(Score score) {
        this.score= score;
    }

    public void incrementScore(int value){
        score.setScore(score.getScore()+value);
    }

    public int getScore(){
        return score.getScore();
    }

    @Override
    void friendPickedUp() {
        if (!hasStarBeenPickedUp || score.getScore() == 0) {
            score.setScore(score.getScore()+50);
        }
        if (hasStarBeenPickedUp) {
            score.setScore(score.getScore()+100);
        }
    }

    @Override
    void friendDroppedOff() {
        if (!hasStarBeenPickedUp || score.getScore() == 0) {
            score.setScore(score.getScore()+50);
        }
        if (hasStarBeenPickedUp) {
            score.setScore(score.getScore()+100);
        }
    }

    @Override
    void pickedStar() {
        score.setScore(score.getScore()*2);
        hasStarBeenPickedUp = true;
    }

}

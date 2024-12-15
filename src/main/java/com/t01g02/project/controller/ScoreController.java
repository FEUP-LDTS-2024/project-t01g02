package com.t01g02.project.controller;


import com.t01g02.project.model.Score;

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
        score.setScore(score.getScore()+50);
        if (hasStarBeenPickedUp) {
            score.setScore(score.getScore()*2);
        }
    }

    @Override
    void friendDroppedOff() {
        score.setScore(score.getScore()+50);
        if (hasStarBeenPickedUp) {
            score.setScore(score.getScore()*2);
        }
    }

    @Override
    void pickedStar() {
        score.setScore(score.getScore()*2);
        hasStarBeenPickedUp = true;
    }

}

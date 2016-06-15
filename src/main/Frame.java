package main;

public class Frame {

    public static final int NUMBER_OF_FRAME_PIN = 10;
    Integer score;

    Integer firstRollPinsDown;
    Integer secondRollPinsDown;
    Boolean isSpare;
    Boolean isStrike;

    Boolean isFrameComplete;

    public Frame() {
        this.score = 0;
        this.firstRollPinsDown = null;
        this.secondRollPinsDown = null;
        this.isFrameComplete = Boolean.FALSE;
        this.isSpare = Boolean.FALSE;
        this.isStrike = Boolean.FALSE;
    }

    public void roll(Integer pinDown){
        score += pinDown;

        if(firstRollPinsDown == null){
            this.firstRollPinsDown = pinDown;
            manageStrike(score);
        } else if(secondRollPinsDown == null){
            this.secondRollPinsDown = pinDown;
            setFrameAsComplete();
            manageSpare(score);
        }
    }

    private void manageStrike(Integer score) {
        if(areAllPinDown(score)){
            setFrameAsComplete();
            this.isStrike = Boolean.TRUE;
        }
    }

    private boolean areAllPinDown(Integer score) {
        return score == NUMBER_OF_FRAME_PIN;
    }

    private void manageSpare(Integer score) {
        if(areAllPinDown(score)){
            this.isSpare = Boolean.TRUE;
        }
    }

    private void setFrameAsComplete(){
        this.isFrameComplete = Boolean.TRUE;
    }

    public boolean isTheFirstRollPlayed() {
        return this.firstRollPinsDown != null;
    }

    public boolean isTheSecondRollPlayed() {
        return this.secondRollPinsDown != null;
    }

}

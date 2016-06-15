package main;

import java.util.ArrayList;
import java.util.List;

import static main.FramesHandler.existPreviousFrame;
import static main.FramesHandler.getFrameToPlay;

public class Game {

    private List<Frame> frames;

    public Game() {
        this.frames = new ArrayList();

        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }

    }

    public Integer totalScore() {
        Integer result = 0;

        for (int position = 0; position < 10; position++) {

            Frame frame = frames.get(position);

            if (frame.isTheFirstRollPlayed()) {

                Frame previousFrame = FramesHandler.getPreviousFrame(
                        frames,
                        position
                );

                result += getFirstRollScore(
                        frame.firstRollPinsDown,
                        previousFrame
                );

                if (frame.isTheSecondRollPlayed()) {
                    result += getSecondRollScore(
                            frame.secondRollPinsDown,
                            previousFrame
                    );
                }

            }

        }

        return result;
    }

    private Integer getSecondRollScore(Integer secondRollPinsDown, Frame previousFrame) {
        return ScoreHandler.getRollScore(
                secondRollPinsDown,
                existPreviousFrame(previousFrame) && previousFrame.isStrike
        );
    }

    private Integer getFirstRollScore(Integer firstRollPinsDown, Frame previousFrame) {
        return ScoreHandler.getRollScore(
                firstRollPinsDown,
                existPreviousFrame(previousFrame) && (previousFrame.isSpare || previousFrame.isStrike)
        );
    }

    public void roll(int pins) {

        Frame frameToPlay = getFrameToPlay(frames);
        frameToPlay.roll(pins);

    }


}

package main;

import java.util.List;

public class FramesHandler {

    public static Frame getPreviousFrame(List<Frame> frames, Integer position) {
        return position == 0 ? null : frames.get(position - 1);
    }

    public static Frame getFrameToPlay(List<Frame> frames) {
        Frame result = null;

        for (Frame frame : frames) {
            if (!frame.isFrameComplete) {
                result = frame;
                break;
            }
        }
        return result;
    }

    public static boolean existPreviousFrame(Frame previousFrame) {
        return previousFrame != null;
    }

}

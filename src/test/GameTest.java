package test;

import main.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {

        game = new Game();

    }

    @Test
    public void totalScoreReturn6IfFirtRollPutDownTwoPinsAndSecond4(){

        game.roll(2);
        game.roll(4);

        assertEquals(new Integer(6), game.totalScore());

    }

    @Test
    public void totalScoreReturn0IfFirtRollPutDownZeroPinsAndSecondZero(){

        game.roll(0);
        game.roll(0);

        assertEquals(new Integer(0), game.totalScore());

    }

    @Test
    public void twoFrameReturn16IfTheFirstScore6PinsAndTheSecond10() throws Exception {

        game.roll(3);
        game.roll(3);
        game.roll(3);
        game.roll(7);

        assertEquals(new Integer(16), game.totalScore());

    }

    @Test
    public void ifTheFirstFrameScore10ASpareTheFirstRollOfTheSecondSpareIsDouble(){

        game.roll(3);
        game.roll(7);
        game.roll(3);

        assertEquals(new Integer(16), game.totalScore());

    }

    @Test
    public void threeFramesWithTwoSpareHaveProperScore(){

        game.roll(3);
        game.roll(7); //10
        game.roll(4); //8
        game.roll(6); //6
        game.roll(1); //2
        game.roll(3); //3

        assertEquals(new Integer(29), game.totalScore());

    }

    @Test
    public void complateGameWithoutBonus() throws Exception {

        game.roll(3);
        game.roll(6); //9
        game.roll(4); //
        game.roll(5); //9
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4
        game.roll(1); //
        game.roll(3); //4

        assertEquals(new Integer(50), game.totalScore());

    }

    @Test
    public void frameAfterAStrikeGetDoubleForBothFrameRolls() throws Exception {

        game.roll(10);
        game.roll(6);
        game.roll(3);

        assertEquals(new Integer(28), game.totalScore());

    }

    @Test
    public void treeFramesWithFirstTwoFrameHavingAStrike() throws Exception {

        game.roll(10);
        game.roll(10);
        game.roll(4);
        game.roll(4);

        assertEquals(new Integer(46), game.totalScore());

    }
}

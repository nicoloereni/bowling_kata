package main;

public class ScoreHandler {

    public static Integer getRollScore(Integer pinDown, Boolean bonusCondition) {
        Integer result = pinDown;

        if (bonusCondition) {
            result += pinDown;
        }

        return result;

    }

}

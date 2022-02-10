package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class Calc {
    private static final String RULE_OF_THE_GAME = "What is the result of the expression?";
    private static final int RANGE_OF_OPERATIONS = 3;
    private static final String[] OPERATIONS = {"+", "-", "*"};

    public static void start() {
        String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int randomNumber1 = Settings.randomNum();
            int randomNumber2 = Settings.randomNum();

            String randomOperation = makeRandomOperation();

            questionsWithAnswers[0][i] = randomNumber1 + " " + randomOperation + " " + randomNumber2;
            questionsWithAnswers[1][i] = String.valueOf(calculate(randomNumber1, randomNumber2, randomOperation));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    private static String makeRandomOperation() {
        int randomNumber = Settings.randomNum(RANGE_OF_OPERATIONS);
        return OPERATIONS[randomNumber];
    }

    private static int calculate(int randomNumber1, int randomNumber2, String randomOperation) {
        if (randomOperation.equals("+")) {
            return randomNumber1 + randomNumber2;
        }
        if (randomOperation.equals("-")) {
            return randomNumber1 - randomNumber2;
        }
        return randomNumber1 * randomNumber2;
    }
}

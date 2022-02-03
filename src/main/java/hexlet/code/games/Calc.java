package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class Calc {
    private static final String RULE_OF_THE_GAME = "What is the result of the expression?";
    private static final int RANGE_OF_OPERATIONS = 3;

    public static void start() {
        String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int[] randomNumbers = new int[2];
            randomNumbers[0] = Settings.randomNum();
            randomNumbers[1] = Settings.randomNum();

            String randomOperation = makeRandomOperation();

            questionsWithAnswers[0][i] =  randomNumbers[0] + " " + randomOperation + " " + randomNumbers[1];
            questionsWithAnswers[1][i] = String.valueOf(getCorrectAnswer(randomNumbers, randomOperation));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    public static String makeRandomOperation() {
        int randomNumber = Settings.randomNum(RANGE_OF_OPERATIONS);

        if (randomNumber == 0) {
            return "+";
        }
        if (randomNumber == 1) {
            return "-";
        }
        return "*";
    }

    public static int getCorrectAnswer(int[] randomNumbers, String randomOperation) {
        if (randomOperation.equals("+")) {
            return randomNumbers[0] + randomNumbers[1];
        }
        if (randomOperation.equals("-")) {
            return randomNumbers[0] - randomNumbers[1];
        }
        return randomNumbers[0] * randomNumbers[1];
    }
}

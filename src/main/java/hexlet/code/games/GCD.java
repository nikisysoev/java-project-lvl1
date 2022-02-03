package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class GCD {
    private static final String RULE_OF_THE_GAME = "Find the greatest common divisor of given numbers.";

    public static void start() {
        String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int[] randomNumbers = new int[2];
            randomNumbers[0] = Settings.randomNum();
            randomNumbers[1] = Settings.randomNum();

            questionsWithAnswers[0][i] = randomNumbers[0] + " " + randomNumbers[1];

            questionsWithAnswers[1][i] = String.valueOf(getCorrectAnswer(randomNumbers));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    public static int getCorrectAnswer(int[] randomNumbers) {
        int min = Math.min(randomNumbers[0], randomNumbers[1]);
        int max = Math.max(randomNumbers[0], randomNumbers[1]);

        while (min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return  max;
    }
}

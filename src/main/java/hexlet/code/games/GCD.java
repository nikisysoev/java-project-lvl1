package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class GCD {
    private static final String RULE_OF_THE_GAME = "Find the greatest common divisor of given numbers.";

    public static void start() {
        final String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int randomNumber1 = Settings.randomNum();
            int randomNumber2 = Settings.randomNum();

            questionsWithAnswers[0][i] = randomNumber1 + " " + randomNumber2;

            questionsWithAnswers[1][i] = String.valueOf(getGcd(randomNumber1, randomNumber2));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    private static int getGcd(int randomNumber1, int randomNumber2) {
        int min = Math.min(randomNumber1, randomNumber2);
        int max = Math.max(randomNumber1, randomNumber2);

        while (min != 0) {
            int remainder = max % min;
            max = min;
            min = remainder;
        }
        return  max;
    }
}

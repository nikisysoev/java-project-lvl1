package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class Prime {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int randomNumber = Settings.randomNum();

            questionsWithAnswers[0][i] = String.valueOf(randomNumber);

            int count = findNumberOfDivisors(randomNumber);

            questionsWithAnswers[1][i] = getCorrectAnswer(count);
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    public static String getCorrectAnswer(int count) {
        return (count == 1) ? "yes" : "no";
    }

    public static int findNumberOfDivisors(int randomNumber) {
        if (randomNumber == 0 || randomNumber == 1) {
            return -1;
        }

        int count = 1;
        int i = 2;
        while (count == 1 && i <= randomNumber / 2) {
            if (randomNumber % i == 0) {
                count++;
            }
            i++;
        }
        return count;
    }
}

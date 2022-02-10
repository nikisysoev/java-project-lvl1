package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class Prime {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        final String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int randomNumber = Settings.randomNum();

            questionsWithAnswers[0][i] = String.valueOf(randomNumber);

            questionsWithAnswers[1][i] = getCorrectAnswer(isPrime(randomNumber));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    private static String getCorrectAnswer(boolean isPrime) {
        return isPrime ? "yes" : "no";
    }

    private static boolean isPrime(int randomNumber) {
        if (randomNumber == 0 || randomNumber == 1) {
            return false;
        }

        for (int i = 2; i <= randomNumber / 2; i++) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}

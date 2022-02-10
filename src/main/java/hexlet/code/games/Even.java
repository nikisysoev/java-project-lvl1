package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;

public class Even {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        final String[][] questionsWithAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int randomNumber = Settings.randomNum();

            questionsWithAnswers[0][i] = String.valueOf(randomNumber);

            questionsWithAnswers[1][i] = getCorrectAnswer(isEven(randomNumber));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsWithAnswers);
    }

    private static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }

    private static String getCorrectAnswer(boolean isEven) {
        return isEven ? "yes" : "no";
    }
}



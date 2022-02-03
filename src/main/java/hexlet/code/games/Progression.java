package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Settings;
import java.util.Arrays;

public class Progression {
    private static final String RULE_OF_THE_GAME = "What number is missing in the progression?";
    private static final int RANGE_OF_PROGRESSION = 6;
    private static final int ADDITION = 11;

    public static void start() {
        String[][] questionsAndCorrectAnswers = new String[2][Settings.ATTEMPTS];

        for (int i = 0; i < Settings.ATTEMPTS; i++) {
            int[] progression = makeProgression();
            int positionOfHiddenNum = Settings.randomNum(progression.length);

            questionsAndCorrectAnswers[1][i] = String.valueOf(progression[positionOfHiddenNum]);

            questionsAndCorrectAnswers[0][i] = hideNumber(progression, positionOfHiddenNum);
        }
        Engine.makeGame(RULE_OF_THE_GAME, questionsAndCorrectAnswers);
    }

    public static int[] makeProgression() {
        int addition = Settings.randomNum(ADDITION);

        int fromZeroToFive = Settings.randomNum(RANGE_OF_PROGRESSION);
        int countNumInProgression = RANGE_OF_PROGRESSION + fromZeroToFive;

        int firstNumOfProgression = Settings.randomNum();

        int[] progression = new int[countNumInProgression];
        progression[0] = firstNumOfProgression;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + addition;
        }
        return progression;
    }

    public static String hideNumber(int[] progression, int positionOfHiddenNum) {
        progression[positionOfHiddenNum] = -1;

        String question = Arrays.toString(progression);

        return question.replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace("-1", "..");
    }
}



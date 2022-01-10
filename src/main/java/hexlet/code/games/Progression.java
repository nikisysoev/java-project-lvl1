package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;

public class Progression {
    private static final int RANGE_OF_RANDOM_NUMBERS_PROGRESSION = 5;
    private static final String RULE_OF_THE_GAME = "What number is missing in the progression?";

    public static void start() {
        Engine.showRuleOfGame(RULE_OF_THE_GAME);

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int firstNumberOfProgression = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int addition = Engine.makeRandomNumber(RANGE_OF_RANDOM_NUMBERS_PROGRESSION) + 1;
            int countNumInProgression = RANGE_OF_RANDOM_NUMBERS_PROGRESSION + addition - 1;
            int positionOfUnknownNumber = Engine.makeRandomNumber(countNumInProgression);

            String[] allNumbers = new String[countNumInProgression];
            makeProgrWithDots(allNumbers, positionOfUnknownNumber, firstNumberOfProgression, addition);
            Engine.showQuestionOfGame(Arrays.toString(allNumbers));

            String correctAnswer = getCorrectAnswer(firstNumberOfProgression, addition, positionOfUnknownNumber);

            String answer = Engine.getAnswerOfUser();

            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
    }

    public static String getCorrectAnswer(int firstNumberOfProgression, int addition, int positionOfUnknownNumber) {
        int correctAnswer = firstNumberOfProgression + positionOfUnknownNumber * addition;
        return Integer.toString(correctAnswer);
    }

    public static void makeProgrWithDots(String[] allNum, int posOfUnknownNum, int firstNumOfProgr, int addition) {
        for (int k = 0; k < allNum.length; k++) {
            if (k != posOfUnknownNum) {
                allNum[k] = Integer.toString(firstNumOfProgr + k * addition);
            } else {
                allNum[k] = ".. ";
            }
        }
    }
}



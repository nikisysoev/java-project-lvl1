package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Arrays;

public class Progression {
    private static final String RULE_OF_THE_GAME = "What number is missing in the progression?";
    private static final int NUMBER_OF_ATTEMPTS = 3;
    private static final int RANGE_OF_RANDOM_NUMBERS = 99;
    private static final int RANGE_OF_RANDOM_NUMBERS_PROGRESSION = 5;

    public static void start() {
        String[] questions = new String[NUMBER_OF_ATTEMPTS];
        String[] correctAnswers = new String[NUMBER_OF_ATTEMPTS];
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            int firstNumbOfProgression = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            int addition = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS_PROGRESSION) + 1;
            int countNumInProgression = RANGE_OF_RANDOM_NUMBERS_PROGRESSION + addition - 1;
            int positionOfUnknownNum = makeRandomNumber(countNumInProgression);
            String[] allNumbers = new String[countNumInProgression];
            questions[i] = makeProgrWithDots(allNumbers, positionOfUnknownNum, firstNumbOfProgression, addition);
            correctAnswers[i] = getCorrectAnswer(firstNumbOfProgression, addition, positionOfUnknownNum);
        }
        Engine.makeGame(RULE_OF_THE_GAME, questions, correctAnswers);
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static String getCorrectAnswer(int firstNumberOfProgression, int addition, int positionOfUnknownNumber) {
        int correctAnswer = firstNumberOfProgression + positionOfUnknownNumber * addition;
        return Integer.toString(correctAnswer);
    }

    public static String makeProgrWithDots(String[] allNum, int posOfUnknownNum, int firstNumOfProgr, int addition) {
        for (int k = 0; k < allNum.length; k++) {
            if (k != posOfUnknownNum) {
                allNum[k] = Integer.toString(firstNumOfProgr + k * addition);
            } else {
                allNum[k] = "..";
            }
        }
        String question = Arrays.toString(allNum);
        return question.replace("[", "").
                replace("]", "").
                replace(",", "");
    }
}



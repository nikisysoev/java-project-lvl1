package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String RULE_OF_THE_GAME = "What is the result of the expression?";
    private static final int NUMBER_OF_ATTEMPTS = 3;
    private static final int RANGE_OF_RANDOM_NUMBERS = 99;
    private static final int THE_FIRST_RANGE = 3;
    private static final int THE_SECOND_RANGE = THE_FIRST_RANGE * 2;

    public static void start() {
        String[] questions = new String[NUMBER_OF_ATTEMPTS];
        String[] correctAnswers = new String[NUMBER_OF_ATTEMPTS];
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            int randomNumber1 = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            String randomOperation = makeRandomOperation(RANGE_OF_RANDOM_NUMBERS);
            questions[i] = randomNumber1 + " " + randomOperation + " " + randomNumber2;
            correctAnswers[i] = Integer.toString(getCorrectAnswer(randomNumber1, randomNumber2, randomOperation));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questions, correctAnswers);
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static String makeRandomOperation(int rangeOfRandomNumbers) {
        int randomNumber = makeRandomNumber(rangeOfRandomNumbers);

        if (randomNumber < (rangeOfRandomNumbers / THE_FIRST_RANGE)) {
            return "+";
        }
        if (randomNumber < (rangeOfRandomNumbers / THE_SECOND_RANGE)) {
            return "-";
        }
        return "*";
    }

    public static int getCorrectAnswer(int randomNumber1, int randomNumber2, String randomOperation) {
        if (randomOperation.equals("+")) {
            return randomNumber1 + randomNumber2;
        }
        if (randomOperation.equals("-")) {
            return randomNumber1 - randomNumber2;
        }
        return randomNumber1 * randomNumber2;
    }
}

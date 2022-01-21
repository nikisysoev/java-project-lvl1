package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String RULE_OF_THE_GAME = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_OF_ATTEMPTS = 3;
    private static final int RANGE_OF_RANDOM_NUMBERS = 99;

    public static void start() {
        String[] questions = new String[NUMBER_OF_ATTEMPTS];
        String[] correctAnswers = new String[NUMBER_OF_ATTEMPTS];
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            int randomNumber1 = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            questions[i] = randomNumber1 + " " + randomNumber2;
            correctAnswers[i] = Integer.toString(getCorrectAnswer(randomNumber1, randomNumber2));
        }
        Engine.makeGame(RULE_OF_THE_GAME, questions, correctAnswers);
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static int getCorrectAnswer(int randomNumber1, int randomNumber2) {
        if (randomNumber1 == randomNumber2) {
            return randomNumber1;
        }
        if (randomNumber1 == 0) {
            return randomNumber2;
        }
        if (randomNumber2 == 0) {
            return randomNumber1;
        }
        int min = Math.min(randomNumber1, randomNumber2);
        for (int i = min; i > 0; i--) {
            if (randomNumber1 % i == 0 && randomNumber2 % i == 0) {
                return i;
            }
        }
        return 0;
    }
}

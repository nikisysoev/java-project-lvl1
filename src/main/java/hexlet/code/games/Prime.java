package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int NUMBER_OF_ATTEMPTS = 3;
    private static final int RANGE_OF_RANDOM_NUMBERS = 99;

    public static void start() {
        String[] questions = new String[NUMBER_OF_ATTEMPTS];
        String[] correctAnswers = new String[NUMBER_OF_ATTEMPTS];
        for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            int randomNumber = makeRandomNumber(RANGE_OF_RANDOM_NUMBERS);
            questions[i] = Integer.toString(randomNumber);
            correctAnswers[i] = getCorrectAnswer(randomNumber);
        }
        Engine.makeGame(RULE_OF_THE_GAME, questions, correctAnswers);
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static String getCorrectAnswer(int randomNumber) {
        var count = 0;
        for (int i = 2; i <= randomNumber; i++) {
            if (randomNumber % i == 0) {
                count++;
            }
        }
        if (count == 1) {
            return "yes";
        }
        return "no";
    }
}

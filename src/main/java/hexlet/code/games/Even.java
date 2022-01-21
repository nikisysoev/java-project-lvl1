package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        if (randomNumber % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}



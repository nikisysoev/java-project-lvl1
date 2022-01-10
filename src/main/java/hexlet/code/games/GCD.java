package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static final String RULE_OF_THE_GAME = "Find the greatest common divisor of given numbers.";

    public static void start() {
        Engine.showRuleOfGame(RULE_OF_THE_GAME);

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int randomNumber1 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);

            Engine.showQuestionOfGame(randomNumber1 + " " + randomNumber2);

            String correctAnswer = Integer.toString(getCorrectAnswer(randomNumber1, randomNumber2));

            String answer = Engine.getAnswerOfUser();

            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
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

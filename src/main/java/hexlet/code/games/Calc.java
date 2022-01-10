package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String RULE_OF_THE_GAME = "What is the result of the expression?";
    private static final int THE_FIRST_RANGE = 3;
    private static final int THE_SECOND_RANGE = THE_FIRST_RANGE * 2;

    public static void start() {
        Engine.showRuleOfGame(RULE_OF_THE_GAME);

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int randomNumber1 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            String randomOperation = makeRandomOperation(Engine.RANGE_OF_RANDOM_NUMBERS);

            Engine.showQuestionOfGame(randomNumber1 + " " + randomOperation + " " + randomNumber2);

            String correctAnswer = Integer.toString(getCorrectAnswer(randomNumber1, randomNumber2, randomOperation));

            String answer = Engine.getAnswerOfUser();

            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
    }

    public static String makeRandomOperation(int rangeOfRandomNumbers) {
        int randomNumber = Engine.makeRandomNumber(rangeOfRandomNumbers);

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

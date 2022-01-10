package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        Engine.showRuleOfGame(RULE_OF_THE_GAME);

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int randomNumber = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);

            Engine.showQuestionOfGame(Integer.toString(randomNumber));

            String correctAnswer = getCorrectAnswer(randomNumber);

            String answer = Engine.getAnswerOfUser();

            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
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

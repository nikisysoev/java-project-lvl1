package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String RULE_OF_THE_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        if (randomNumber % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}



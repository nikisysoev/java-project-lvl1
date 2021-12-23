package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Even {
    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var i = 0;
        while (i < Engine.NUMBER_OF_CHECKS && !Engine.getIsUserMakeMistake()) {
            int randomNumber = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            String correctAnswer = Engine.getCorrectAnswer(randomNumber);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            Cli.readInput();
            String answer = Cli.getInput();
            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkIsUserMakeMistake();
    }
}



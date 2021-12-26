package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class GCD {
    public static void start() {
        System.out.println("Find the greatest common divisor of given numbers.");

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int randomNumber1 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);

            String correctAnswer = Engine.getCorrectAnswer(randomNumber1, randomNumber2);

            System.out.println("Question: " + randomNumber1 + " " + randomNumber2);
            System.out.print("Your answer: ");

            Cli.readInput();
            String answer = Cli.getInput();
            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
    }
}

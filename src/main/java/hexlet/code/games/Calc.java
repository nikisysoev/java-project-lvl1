package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Calc {
    public static void start() {
        System.out.println("What is the result of the expression?");

        var i = 0;
        while (i < Engine.NUMBER_OF_ATTEMPTS && !Engine.getHasUserMistake()) {
            int randomNumber1 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int randomNumber2 = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            String randomOperation = Engine.makeRandomOperation(Engine.RANGE_OF_RANDOM_NUMBERS);

            String correctAnswer = Engine.getCorrectAnswer(randomNumber1, randomNumber2, randomOperation);

            System.out.println("Question: " + randomNumber1 + " " + randomOperation + " " + randomNumber2);
            System.out.print("Your answer: ");

            Cli.readInput();
            String answer = Cli.getInput();
            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkHasUserMistake();
    }
}

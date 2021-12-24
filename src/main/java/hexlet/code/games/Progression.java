package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Progression {
    public static void start() {
        System.out.println("What number is missing in the progression?");

        var i = 0;
        while (i < Engine.NUMBER_OF_CHECKS && !Engine.getIsUserMakeMistake()) {
            int firstNumberOfProgression = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS);
            int addition = Engine.makeRandomNumber(Engine.RANGE_OF_RANDOM_NUMBERS_PROGRESSION) + 1;
            int countNumbers = Engine.RANGE_OF_RANDOM_NUMBERS_PROGRESSION + addition - 1;
            int positionOfUnknownNumber = Engine.makeRandomNumber(countNumbers);

            String[] allNumbers = new String[countNumbers];
            String correctAnswer = Engine.getCorrectAnswer(firstNumberOfProgression, addition, positionOfUnknownNumber);

            System.out.print("Question: ");
            for (int k = 0; k < allNumbers.length; k++) {
                allNumbers[k] = Integer.toString(firstNumberOfProgression + k * addition);
                if (k == positionOfUnknownNumber) {
                    System.out.print(".. ");
                } else {
                    System.out.print(allNumbers[k] + " ");
                }
            }

            System.out.print("\nYour answer: ");
            Cli.readInput();
            String answer = Cli.getInput();
            Engine.checkAnswersOfUser(correctAnswer, answer);
            i++;
        }
        Engine.checkIsUserMakeMistake();
    }
}



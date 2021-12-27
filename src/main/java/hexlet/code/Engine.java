package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class Engine {
    public static final int NUMBER_OF_ATTEMPTS = 3;
    public static final int RANGE_OF_RANDOM_NUMBERS = 99;
    public static final int RANGE_OF_RANDOM_NUMBERS_PROGRESSION = 5;
    private static final int FIRST_RANGE_OF_RANDOM_NUM_CALC = 99 / 3;
    private static final int SECOND_RANGE_OF_RANDOM_NUM_CALC = FIRST_RANGE_OF_RANDOM_NUM_CALC * 2;

    private static boolean hasUserMistake = false;

    public static boolean getHasUserMistake() {
        return hasUserMistake;
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static String makeRandomOperation(int rangeOfRandomNumbers) {
        int randomNumber = makeRandomNumber(rangeOfRandomNumbers);
        if (randomNumber < FIRST_RANGE_OF_RANDOM_NUM_CALC) {
            return "+";
        }
        if (randomNumber < SECOND_RANGE_OF_RANDOM_NUM_CALC) {
            return "-";
        }
        return "*";
    }

    public static String getCorrectAnswer(int randomNumber1, int randomNumber2, String randomOperation) {
        if (randomOperation.equals("+")) {
            return Integer.toString(randomNumber1 + randomNumber2);
        }
        if (randomOperation.equals("-")) {
            return Integer.toString(randomNumber1 - randomNumber2);
        }
        return Integer.toString(randomNumber1 * randomNumber2);
    }

    public static String getCorrectAnswer(int randomNumber) {
        if (randomNumber % 2 == 0) {
            return "yes";
        }
        return "no";
    }

    public static String getCorrectAnswer(int randomNumber1, int randomNumber2) {
        if (randomNumber1 == randomNumber2) {
            return Integer.toString(randomNumber1);
        }
        if (randomNumber1 == 0) {
            return Integer.toString(randomNumber2);
        }
        if (randomNumber2 == 0) {
            return Integer.toString(randomNumber1);
        }
        int min = Math.min(randomNumber1, randomNumber2);
        for (int i = min; i > 0; i--) {
            if (randomNumber1 % i == 0 && randomNumber2 % i == 0) {
                return Integer.toString(i);
            }
        }
        return "";
    }

    public static String getCorrectAnswer(int firstNumberOfProgression, int addition, int positionOfUnknownNumber) {
        int correctAnswer = firstNumberOfProgression + positionOfUnknownNumber * addition;
        return Integer.toString(correctAnswer);
    }

    public static String getCorrectAnswer(int randomNumber, String prime) {
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

    public static void checkAnswersOfUser(String correctAnswer, String answer) {
        if (correctAnswer.equals(answer)) {
            System.out.println("Correct!");
        } else {
            hasUserMistake = true;
            System.out.print("'" + answer + "'" + " is wrong answer ;(. ");
            System.out.println("Correct answer was " + "'" + correctAnswer + "'" + ".");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
        }
    }

    public static void checkHasUserMistake() {
        if (!hasUserMistake) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }

    public static void menuStart() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    public static void chooseGame() {
        Cli.readInput();
        String numberOfGame = Cli.getInput();
        switch (numberOfGame) {
            case "1":
                Cli.greet();
                break;
            case "2":
                Cli.greet();
                Even.start();
                break;
            case "3":
                Cli.greet();
                Calc.start();
                break;
            case "4":
                Cli.greet();
                GCD.start();
                break;
            case "5":
                Cli.greet();
                Progression.start();
                break;
            case "6":
                Cli.greet();
                Prime.start();
                break;
            default:
                break;
        }
    }
}

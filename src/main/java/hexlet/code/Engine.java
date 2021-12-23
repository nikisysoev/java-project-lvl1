package hexlet.code;

public class Engine {
    public static final int NUMBER_OF_CHECKS = 3;
    public static final int RANGE_OF_RANDOM_NUMBERS = 99;
    private static final int FIRST_RANGE_OF_RANDOM_NUMBERS = 99 / 3;
    private static final int SECOND_RANGE_OF_RANDOM_NUMBERS = FIRST_RANGE_OF_RANDOM_NUMBERS * 2;
    private static boolean isUserMakeMistake = false;

    public static boolean getIsUserMakeMistake() {
        return isUserMakeMistake;
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static String makeRandomOperation(int rangeOfRandomNumbers) {
        int randomNumber = makeRandomNumber(rangeOfRandomNumbers);
        if (randomNumber < FIRST_RANGE_OF_RANDOM_NUMBERS) {
            return "+";
        }
        if (randomNumber < SECOND_RANGE_OF_RANDOM_NUMBERS) {
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
        int min = Math.min(randomNumber1, randomNumber2);
        for (int i = min; i > 0; i--) {
            if (randomNumber1 % i == 0 && randomNumber2 % i == 0) {
                return Integer.toString(i);
            }
        }
        return "";
    }


    public static void checkAnswersOfUser(String correctAnswer, String answer) {
        if (correctAnswer.equals(answer)) {
            System.out.println("Correct!");
        } else {
            isUserMakeMistake = true;
            System.out.print("'" + answer + "'" + " is wrong answer ;(. ");
            System.out.println("Correct answer was " + "'" + correctAnswer + "'" + ".");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
        }
    }

    public static void checkIsUserMakeMistake() {
        if (!isUserMakeMistake) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }
}

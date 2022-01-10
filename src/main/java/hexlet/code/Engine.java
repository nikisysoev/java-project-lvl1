package hexlet.code;

public class Engine {
    public static final int NUMBER_OF_ATTEMPTS = 3;
    public static final int RANGE_OF_RANDOM_NUMBERS = 99;

    private static boolean hasUserMistake = false;

    public static boolean getHasUserMistake() {
        return hasUserMistake;
    }

    public static int makeRandomNumber(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
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

    public static void showRuleOfGame(String rule) {
        System.out.println(rule);
    }

    public static void showQuestionOfGame(String question) {
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
    }

    public static String getAnswerOfUser() {
        Cli.readInput();
        return Cli.getInput();
    }
}

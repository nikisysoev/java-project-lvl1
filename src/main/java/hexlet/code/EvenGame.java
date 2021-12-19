package hexlet.code;

public class EvenGame {
    private static boolean isUserMakeMistake = false;

    public static void start() {
        final int numberOfChecks = 3;
        final int rangeOfRandomNumbers = 100;
        int randomNumber;
        String correctAnswer;
        String answer;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var i = 0;
        while (i < numberOfChecks && !isUserMakeMistake) {
            randomNumber = (int) (Math.random() * rangeOfRandomNumbers);
            correctAnswer = getCorrectAnswerOfEvenness(randomNumber);

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");

            Cli.readInput();
            answer = Cli.getInput();

            checkAnswersOfUser(correctAnswer, answer);
            i++;
        }

        if (!isUserMakeMistake) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }

    public static String getCorrectAnswerOfEvenness(int randomNumber) {
        if (randomNumber % 2 == 0) {
            return "yes";
        }
        return "no";
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
}



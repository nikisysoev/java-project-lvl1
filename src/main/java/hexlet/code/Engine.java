package hexlet.code;

public class Engine {
    private static final int NUMBER_OF_ATTEMPTS = 3;

    public static void makeGame(String rule, String[] questions, String[] correctAnswers) {
        showRuleOfGame(rule);
        var i = 0;
        boolean isNoMistake = true;
        while (i < NUMBER_OF_ATTEMPTS && isNoMistake) {
            showQuestionOfGame(questions[i]);
            String answer = getAnswerOfUser();
            isNoMistake = correctAnswers[i].equals(answer);
            giveRespondToUser(isNoMistake, answer, correctAnswers[i]);
            i++;
        }
        congratulateUserOrNot(isNoMistake);
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

    public static void giveRespondToUser(boolean isNoMistake, String answer, String correctAnswer) {
        if (isNoMistake) {
            System.out.println("Correct!");
        } else {
            System.out.print("'" + answer + "'" + " is wrong answer ;(. ");
            System.out.println("Correct answer was " + "'" + correctAnswer + "'" + ".");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
        }
    }

    public static void congratulateUserOrNot(boolean isNoMistake) {
        if (isNoMistake) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }
}

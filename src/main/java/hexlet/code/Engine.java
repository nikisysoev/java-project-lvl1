package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void makeGame(String ruleOfTheGame, String[][] questionsAndCorrectAnswers) {
        String nameOfUser  = Cli.greet();

        System.out.println(ruleOfTheGame);

        int i = 0;
        boolean isNoMistake;
        do {
            System.out.println("Question: " + questionsAndCorrectAnswers[0][i]);
            System.out.print("Your answer: ");

            String[][] answers = new String[2][Settings.ATTEMPTS];

            answers[0][i] = getAnswerOfUser();
            answers[1][i] = questionsAndCorrectAnswers[1][i];

            isNoMistake = answers[1][i].equals(answers[0][i]);

            giveRespond(isNoMistake, answers[0][i], answers[1][i], nameOfUser);
            i++;
        } while (i < Settings.ATTEMPTS && isNoMistake);

        congratulateUserOrNot(isNoMistake, nameOfUser);
    }

    public static String getAnswerOfUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void giveRespond(boolean isNoMistake, String userAnswer, String correctAnswer, String nameOfUser) {
        if (isNoMistake) {
            System.out.println("Correct!");
        } else {
            System.out.print("'" + userAnswer + "'" + " is wrong answer ;(. ");
            System.out.println("Correct answer was " + "'" + correctAnswer + "'" + ".");
            System.out.println("Let's try again, " + nameOfUser + "!");
        }
    }

    public static void congratulateUserOrNot(boolean isNoMistake, String nameOfUser) {
        if (isNoMistake) {
            System.out.println("Congratulations, " + nameOfUser + "!");
        }
    }
}

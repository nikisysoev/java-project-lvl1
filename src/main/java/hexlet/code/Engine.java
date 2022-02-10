package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static void makeGame(String ruleOfTheGame, String[][] questionsAndCorrectAnswers) {
        findOutTheName();
        String nameOfUser =  getAnswerOfUser();
        System.out.println("Hello, " + nameOfUser + "!");

        System.out.println(ruleOfTheGame);

        int i = 0;
        boolean isNoMistake;
        do {
            System.out.println("Question: " + questionsAndCorrectAnswers[0][i]);
            System.out.print("Your answer: ");

            String userAnswer = getAnswerOfUser();
            String correctAnswer = questionsAndCorrectAnswers[1][i];

            isNoMistake = correctAnswer.equals(userAnswer);

            giveRespond(isNoMistake, userAnswer, correctAnswer, nameOfUser);
            i++;
        } while (i < Settings.ATTEMPTS && isNoMistake);

        congratulateUserOrNot(isNoMistake, nameOfUser);
    }

    private static void findOutTheName() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
    }

    private static String getAnswerOfUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void giveRespond(boolean isNoMistake, String userAnswer, String correctAnswer, String nameOfUser) {
        if (isNoMistake) {
            System.out.println("Correct!");
        } else {
            System.out.print("'" + userAnswer + "'" + " is wrong answer ;(. ");
            System.out.println("Correct answer was " + "'" + correctAnswer + "'" + ".");
            System.out.println("Let's try again, " + nameOfUser + "!");
        }
    }

    private static void congratulateUserOrNot(boolean isNoMistake, String nameOfUser) {
        if (isNoMistake) {
            System.out.println("Congratulations, " + nameOfUser + "!");
        }
    }
}

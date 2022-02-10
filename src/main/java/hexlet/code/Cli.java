package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        System.out.println("Hello, " + getAnswerOfUser() + "!");
    }

    public static String getAnswerOfUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}


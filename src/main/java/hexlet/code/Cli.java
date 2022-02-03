package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greet() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String nameOfUser = scanner.next();
        System.out.println("Hello, " + nameOfUser + "!");

        return nameOfUser;
    }
}


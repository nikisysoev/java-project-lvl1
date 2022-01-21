package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String input;
    private static String userName;

    public static String getInput() {
        return input;
    }

    public static void setInput(String someInput) {
        input = someInput;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String name) {
        userName = name;
    }

    public static void greet() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        readInput();
        setUserName(getInput());
        System.out.println("Hello, " + getUserName() + "!");
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        setInput(scanner.next());
    }
}


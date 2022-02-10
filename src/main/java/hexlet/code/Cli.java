package hexlet.code;

public class Cli {
    public static void greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        System.out.println("Hello, " + Utils.getAnswerOfUser() + "!");
    }
}


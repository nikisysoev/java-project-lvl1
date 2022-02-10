package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menuStart();
        chooseGame();
    }

    private static void menuStart() {
        String[] games = {"1 - Greet", "2 - Even", "3 - Calc", "4 - GCD", "5 - Progression", "6 - Prime", "0 - Exit"};

        System.out.println("Please enter the game number and press Enter.");

        for (String game : games) {
            System.out.println(game);
        }
        System.out.print("Your choice: ");
    }

    private static void chooseGame() {
        Scanner scanner = new Scanner(System.in);

        switch (scanner.next()) {
            case "1" -> Cli.greet();
            case "2" -> Even.start();
            case "3" -> Calc.start();
            case "4" -> GCD.start();
            case "5" -> Progression.start();
            case "6" -> Prime.start();
            default -> { }
        }
    }
}

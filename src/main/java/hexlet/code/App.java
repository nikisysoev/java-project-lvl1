package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Cli.readInput();
        String numberOfGame = Cli.getInput();

        switch (numberOfGame) {
            case "1":
                Cli.greet();
                break;
            case "2":
                Cli.greet();
                Even.start();
                break;
            case "3":
                Cli.greet();
                Calc.start();
                break;
            case "4":
                Cli.greet();
                GCD.start();
                break;
            case "5":
                Cli.greet();
                Progression.start();
                break;
            case "6":
                Cli.greet();
                Prime.start();
                break;
            default:
                break;
        }
    }
}

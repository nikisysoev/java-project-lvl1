package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
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
                EvenGame.start();
                break;
            default:
                break;
        }
    }
}

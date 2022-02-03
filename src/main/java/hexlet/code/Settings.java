package hexlet.code;

public class Settings {
    public static final int ATTEMPTS = 10;
    public static final int RANGE_OF_RANDOM_NUMBERS = 100;

    public static int randomNum(int rangeOfRandomNumbers) {
        return (int) (Math.random() * rangeOfRandomNumbers);
    }

    public static int randomNum() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBERS);
    }
}

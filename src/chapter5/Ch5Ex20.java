package chapter5;

/**
 * @author swarfte
 * @title Display prime numbers between 2 and 1200
 */
public class Ch5Ex20 {
    public static void main(String[] args) {
        int range = 1200;
        StringBuilder output = new StringBuilder();
        int lineCount = 0;
        for (int i = 2; i < range; i++) {
            if (isPrime(i)) {
                output.append(i).append(" ");
                lineCount++;
            }
            if (lineCount == 8) {
                output.append("\n");
                lineCount = 0;
            }
        }
        System.out.println(output);
    }


    public static boolean isPrime(int number) {
        return isPrime(number, 2, number);
    }

    public static boolean isPrime(int number, int current, int end) {
        if (current == end) {
            return true;
        }
        if (number % current == 0) {
            return false;
        } else {
            return isPrime(number, current + 1, end);
        }
    }
}

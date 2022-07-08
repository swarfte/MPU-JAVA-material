package chapter6;

/**
 * @author swarfte
 * @title Use the isPrime Method
 */
public class Ch6Ex10 {
    public static void main(String[] args) {
        int count = 0;
        int number = 10000;
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                sb.append(i).append(' ');
                count++;
            }
            if (count == 10) {
                sb.append("\n");
                count = 0;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}

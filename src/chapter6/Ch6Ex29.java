package chapter6;

/**
 * @author swarfte
 * @title Twin primes
 */
public class Ch6Ex29 {
    public static void main(String[] args) {
        for (int i = 2; i < 1200; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.printf("(%d, %d)\n", i, i + 2);
            }
        }
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

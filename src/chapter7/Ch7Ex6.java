package chapter7;

import java.util.Arrays;

/**
 * @author swarfte
 * @title The Sieve of Eratosthenes
 */
public class Ch7Ex6 {
    public static void main(String[] args) {

        // give limit n , the size is n + 1
        boolean[] number = new boolean[50 + 1];
        Arrays.fill(number, true);
        sieveOfEratosthenes(number);

        // start from two to show the result
        for (int i = 2; i < number.length; i++) {
            if (number[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void sieveOfEratosthenes(boolean[] number) {
        // start from two
        for (int i = 2; i < number.length; i++) {

            // if i is prime
            if (number[i]) {

                // the multiple of i is not prime
                for (int j = i * 2; j < number.length; j += i) {
                    number[j] = false;
                }
            }
        }
    }
}

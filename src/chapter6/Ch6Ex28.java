package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Mersenne prime
 */
public class Ch6Ex28 {
    public static void main(String[] args) {
        int size = 31;
        System.out.print("p    2^p-1\n");
        System.out.println("-".repeat(15));
        for (int i = 2; i <= size; i++) {
            if (isPrime(i) && isMersenne(i) > 0) {
                System.out.printf("%d    %d\n", i, isMersenne(i));
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

    public static int isMersenne(int p) {
        return isPrime((int) (Math.pow(2, p)) - 1) ? (int) (Math.pow(2, p) - 1) : -1;
    }
}

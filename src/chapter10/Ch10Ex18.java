package chapter10;

import java.math.BigInteger;

/**
 * @author swarfte
 * @title Large prime numbers
 */
public class Ch10Ex18 {
    public static void main(String[] args) {
        BigInteger prime = new BigInteger(String.valueOf(Long.MAX_VALUE));
        int count = 0;
        while (count < 5) {
            boolean isPrime = true;
            for (long i = 2; i < Long.MAX_VALUE; i++) {
                if (prime.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("Prime number: " + prime);
                count++;
            }
            prime = prime.add(new BigInteger(String.valueOf(1)));
        }

    }
}

package chapter10;

import java.math.BigInteger;

/**
 * @author swarfte
 * @title Mersenne prime
 */
public class Ch10Ex19 {
    public static void main(String[] args) {
        BigInteger number = new BigInteger("2");
        System.out.println("p        2^p - 1");
        System.out.println("_________________");
        int count = 0;
        while (count <= 100) {
            BigInteger prime = new BigInteger("1");
            for (long i = 0; i < number.longValue(); i++) {
                prime = prime.multiply(new BigInteger("2"));
            }
            prime = prime.add(new BigInteger("-1"));
            boolean isPrime = true;

            for (long i = 2; i < prime.longValue() - 1; i++) {
                if (prime.mod(new BigInteger(String.valueOf(i))).equals(BigInteger.ZERO)) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(number + "        " + prime);
                count++;
            }
            number = number.add(new BigInteger("1"));
        }
    }
}


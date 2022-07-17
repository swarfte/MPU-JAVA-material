package chapter10;

import java.math.BigInteger;

/**
 * @author swarfte
 * @title Implement the String class
 */
public class Ch10Ex21 {
    public static void main(String[] args) {
        BigInteger number = new BigInteger(String.valueOf(Long.MAX_VALUE));
        int count = 0;
        while (count < 10) {
            if (number.mod(new BigInteger("5")).equals(BigInteger.ZERO) || number.mod(new BigInteger("6")).equals(BigInteger.ZERO)) {
                System.out.println(number);
                count++;
            }
            number = number.add(BigInteger.ONE);
        }
    }
}

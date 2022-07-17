package chapter10;

import java.math.BigInteger;

/**
 * @author swarfte
 * @title Approximate e
 */
public class Ch10Ex20 {
    public static void main(String[] args) {
        for (int number = 100; number <= 1000; number += 100) {
            double e = 0;
            for (int i = 0; i < number; i++) {
                e += 1 / factorial(i).doubleValue();
            }
            System.out.println(e);
        }
    }

    public static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        } else {
            BigInteger result = new BigInteger("1");
            for (int i = 1; i <= n; i++) {
                result = result.multiply(new BigInteger(Integer.toString(i)));
            }
            return result;
        }
    }
}

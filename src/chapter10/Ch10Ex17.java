package chapter10;


import java.math.BigInteger;

/**
 * @author swarfte
 * @title Square numbers
 */
public class Ch10Ex17 {
    public static void main(String[] args) {
        int count = 0;
        BigInteger number = new BigInteger("1");
        BigInteger max = new BigInteger(String.valueOf(Long.MAX_VALUE));
        while (count < 10) {
            BigInteger square = number.multiply(number);
            System.out.println(square.toString());
            if (square.longValue() > max.longValue()) {
                System.out.println(number);
                count++;
            }
            number = number.add(new BigInteger("1"));
        }
    }
}

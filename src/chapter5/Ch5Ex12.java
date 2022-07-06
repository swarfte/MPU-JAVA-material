package chapter5;

/**
 * @author swarfte
 * @title Find the smallest n such that n^3 > 12000
 */
public class Ch5Ex12 {
    public static void main(String[] args) {
        int number = 0;
        while (Math.pow(number, 3) < 12000) {
            number++;
        }
        System.out.println("The smallest n such than n^3 > 12000 is " + number);
    }
}

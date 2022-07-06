package chapter5;

/**
 * @author swarfte
 * @title Find the largest n such that n^2 < 12000
 */
public class Ch5Ex13 {
    public static void main(String[] args) {
        int number = 0;
        while (Math.pow(number, 2) < 12000) {
            number++;
        }
        number--;
        System.out.println("The largest n such than n^2 < 12000 is " + number);
    }
}

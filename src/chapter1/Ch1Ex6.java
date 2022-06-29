package chapter1;

/**
 * @author swarfte
 * @title Summation of a series
 */
public class Ch1Ex6 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

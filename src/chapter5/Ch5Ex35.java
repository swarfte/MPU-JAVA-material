package chapter5;

/**
 * @author swarfte
 * @title Summation
 */
public class Ch5Ex35 {
    public static void main(String[] args) {
        double sum = 0.0;
        for (int i = 1; i < 1000; i++) {
            sum += 1 / (Math.sqrt(i) + Math.sqrt(i + 1));
        }
        System.out.println(sum);
    }
}

package chapter5;

/**
 * @author swarfte
 * @title Compute PI
 */
public class Ch5Ex25 {
    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            System.out.println(computePi(i));
        }
    }

    public static double computePi(int end) {
        double value = 0.0;
        for (int i = 1; i <= end; i++) {
            value += (Math.pow(-1, i + 1)) / (2 * i - 1);
        }
        return 4 * value;
    }
}

package chapter5;

/**
 * @author swarfte
 * @title Sum a series
 */
public class Ch5Ex24 {
    public static void main(String[] args) {
        double value = 0;
        for (int i = 0; i < 49; i++) {
            value += (1.0 + 2 * i) / (3 + 2 * i);
        }
        System.out.println(value);
    }
}

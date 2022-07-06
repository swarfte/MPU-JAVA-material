package chapter5;

/**
 * @author swarfte
 * @title Math: combinations
 */
public class Ch5Ex43 {
    public static void main(String[] args) {
        int start = 1;
        int end = 7;
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                System.out.println("" + i + " " + j);
                count++;
            }
        }
        System.out.println("The total number of all combinations is " + count);
    }
}

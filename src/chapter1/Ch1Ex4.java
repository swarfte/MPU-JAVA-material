package chapter1;

/**
 * @author swarfte
 * @title Print a table
 */
public class Ch1Ex4 {
    public static void main(String[] args) {
        System.out.println("a   a^2   a^3   a^4");
        for (int i = 1; i < 5; i++) {
            System.out.printf("%d   %d   %d   %d\n", i, i * i, i * i * i, i * i * i * i);
        }
    }
}

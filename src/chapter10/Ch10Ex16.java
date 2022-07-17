package chapter10;

/**
 * @author swarfte
 * @title Divisible by 2 or 3
 */
public class Ch10Ex16 {
    public static void main(String[] args) {
        for (int i = 2; i < 50; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (j == 2) {
                        System.out.println(i + " is divisible by 2");
                    }
                    if (j == 3) {
                        System.out.println(i + " is divisible by 3");
                    }
                }
            }
        }
    }
}



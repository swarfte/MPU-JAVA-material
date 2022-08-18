package chapter18.ex14;

import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch18Ex14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        System.out.println("this number is odd?: " + odd(n));
        System.out.println("this number is even?: " + even(n));
    }

    public static boolean odd(int x) {
        return odd(x, false);
    }

    public static boolean odd(int x, boolean isOdd) {
        if (x > 0) {
            return odd(x - 1, !isOdd);
        } else {
            return isOdd;
        }
    }

    public static boolean even(int x) {
        return even(x, true);
    }

    public static boolean even(int x, boolean isEven) {
        if (x > 0) {
            return even(x - 1, !isEven);
        } else {
            return isEven;
        }
    }
}

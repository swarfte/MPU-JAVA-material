package chapter18.ex2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Fibonacci numbers
 */
public class Ch18Ex2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci number: " + fib(n));

    }

    public static int fib(int n) {
        int f0 = 0;
        int f1 = 1;
        for (int i = 1; i <= n; i++) {
            int f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f0;
    }


}

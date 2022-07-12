package chapter7;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author swarfte
 * @title Computing lcm
 */
public class Ch7Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.print("Enter five number : ");
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = scanner.nextInt();
//        }


        System.out.println("10, 20,30,40,50,60,70,80,90,100");
        System.out.println(lcm(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));
    }

    public static int lcm(int... numbers) {
        if (numbers.length == 2) {
            return lcm(numbers[0], numbers[1]);
        } else {
            return lcm(numbers[0], lcm(Arrays.copyOfRange(numbers, 1, numbers.length)));
        }
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public static int gcd(int... numbers) {
        if (numbers.length == 2) {
            return gcd(numbers[0], numbers[1]);
        } else {
            return gcd(numbers[0], gcd(Arrays.copyOfRange(numbers, 1, numbers.length)));
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd(b, a % b);
        }
    }
}

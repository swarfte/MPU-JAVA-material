package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Math: approximate the square root
 */
public class Ch6Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a integer number : ");
        int number = scanner.nextInt();
        System.out.println("The sqrt root of the number is : " + sqrt(number));
    }

    public static double sqrt(long n) {
        double nextGuess = 0;
        double lastGuess = 1;
        while (true) {
            nextGuess = (lastGuess + n / lastGuess) / 2;
            if (Math.abs(nextGuess - lastGuess) > 0.0001) {
                lastGuess = nextGuess;
            } else {
                break;
            }
        }
        return nextGuess;
    }

}

package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game : heads or tails
 */
public class Ch3Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("guess the coin is heads or tails , head = 0, tails = 1 : ");
        int result = (int) (Math.random() * 2);
        int guess = scanner.nextInt();
        if (result == guess) {
            System.out.println("You are correct");
        } else {
            System.out.println("You are incorrect");
        }
    }
}

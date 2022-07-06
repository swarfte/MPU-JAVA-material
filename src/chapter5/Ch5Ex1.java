package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Pass of fail
 */
public class Ch5Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while (true) {
            System.out.print("Enter your score : ");
            score = scanner.nextInt();
            if (score == -1) {
                break;
            }
            if (score >= 60) {
                System.out.println("You pass the exam");
            } else {
                System.out.println("You don't pass the exam");
            }
        }
        System.out.println("No numbers are entered except 0");
    }
}

package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: multiplication quiz
 */
public class Ch3Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 10);

        System.out.printf("What is %d * %d ? ", number1, number2);
        int answer = scanner.nextInt();
        if (number1 * number2 == answer) {
            System.out.println("Your are correct");

        } else {
            System.out.println("Your answer is wrong");
            System.out.printf("%d * %d is %d", number1, number2, number1 * number2);
        }
    }
}

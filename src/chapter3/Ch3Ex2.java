package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: multiply three numbers
 */
public class Ch3Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = ((int) (Math.random() * 100) % 10);
        int number2 = ((int) (Math.random() * 100) % 10);
        int number3 = ((int) (Math.random() * 100) % 10);
        System.out.printf("What is %d * %d * %d : ", number1, number2, number3);
        int answer = scanner.nextInt();
        System.out.printf("%d * %d * %d = %d is %b", number1, number2, number3, answer, (number1 * number2 * number3 == answer));
    }
}

package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Repeat multiplications
 */
public class Ch5Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUMBER_OF_QUESTIONS = 10;
        int correctCount = 0;
        long startTime = System.currentTimeMillis();
        StringBuilder output = new StringBuilder(" ");
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int number1 = (int) (Math.random() * 12) + 1;
            int number2 = (int) (Math.random() * 12) + 1;

            System.out.printf("What is %d * %d ? ", number1, number2);
            int answer = scanner.nextInt();

            if (number1 * number2 == answer) {
                System.out.println("Your are correct");
                correctCount++;
            } else {
                System.out.printf("Your answer is wrong.\n %d * %d should be %d\n", number1, number2, number1 * number2);
            }
            output.append("\n").append(number1).append(" * ").append(number2).append(" = ").append(answer).append((number1 * number2 == answer) ? " correct " : " wrong ");
        }
        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;
        System.out.printf("\n Correct count is %d \n Test time is %d seconds \n %s", correctCount, testTime / 1000, output);
    }
}

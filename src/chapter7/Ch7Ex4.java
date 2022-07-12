package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Analyze scores
 */
public class Ch7Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a integer until a negative number: ");
        int[] number = new int[100];
        int count = 0;
        while (true) {
            int check = scanner.nextInt();
            if (check < 0) {
                break;
            } else {
                number[count] = check;
                count++;
            }
        }
        analyzeScore(number, count);
    }

    public static void analyzeScore(int[] scores, int length) {
        int average = 0;
        for (int i = 0; i < length; i++) {
            average += scores[i];
        }
        average /= length;
        System.out.println("Average: " + average);
        for (int i = 0; i < length; i++) {
            if (scores[i] >= average) {
                System.out.println("Above or equal to the average: " + scores[i]);
            } else {
                System.out.println("Below the average: " + scores[i]);
            }
        }
    }
}

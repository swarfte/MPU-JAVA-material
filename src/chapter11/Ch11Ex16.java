package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Addition quiz
 */
public class Ch11Ex16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int answer = number1 + number2;
        boolean correct = false;
        while (!correct) {
            System.out.print("What is " + number1 + " + " + number2 + "? ");
            int guess = scanner.nextInt();
            if (guess == answer) {
                System.out.println("Your got it!");
                correct = true;
            } else {
                if (answerList.contains(guess)) {
                    System.out.println("You already entered " + guess);
                } else {
                    answerList.add(guess);
                }
                answerList.add(guess);
                System.out.print("Wrong answer. Try again.");
            }
        }
    }

}

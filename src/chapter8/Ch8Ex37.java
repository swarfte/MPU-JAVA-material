package chapter8;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Guess the capitals
 */
public class Ch8Ex37 {
    public static void main(String[] args) {
        String[][] stateTable = {
                {"Alabama", "Alaska", "Arizona"},
                {"Montgomery", "Juneau", "Phoenix"}
        };
        startGame(stateTable);
    }

    public static void startGame(String[][] stateTable) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < stateTable[0].length; i++) {
            System.out.printf("What is the capital of %s ? ", stateTable[0][i]);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase(stateTable[1][i])) {
                System.out.println("Your answer is correct");
                count++;
            } else {
                System.out.printf("The correct answer should be %s\n", stateTable[1][i]);
            }
        }
        System.out.printf("The correct count is %d", count);
    }
}

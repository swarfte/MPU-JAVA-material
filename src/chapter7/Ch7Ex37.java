package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: bean machine
 */
public class Ch7Ex37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop:");
        int ballsNumber = scanner.nextInt();
        System.out.print("Enter the number of slots in the bean machine : ");
        int slotsNumber = scanner.nextInt();
        System.out.println();
        int[][] slots = buildSlots(slotsNumber, ballsNumber);
        for (int i = 0; i < ballsNumber; i++) {
            String path = generatesBallToDrop(slotsNumber);
            System.out.println(path);
            int index = calculatePath(path);
            addSlots(slots, index);
        }
        System.out.println();
        showResult(slots);

    }

    public static void showResult(int[][] slots) {
        for (int[] slot : slots) {
            for (int i : slot) {
                if (i == 1) {
                    System.out.print(0);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void addSlots(int[][] slots, int index) {
        for (int i = slots.length - 1; i >= 0; i--) {
            if (slots[i][index] == 0) {
                slots[i][index] = 1;
                break;
            }
        }
    }

    public static int calculatePath(String path) {
        int index = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                index++;
            }
        }
        return index;
    }

    public static int[][] buildSlots(int numberOfSlots, int numberOfBalls) {
        int[][] slots = new int[numberOfBalls][numberOfSlots];
        // initialize the slots
        for (int i = 0; i < numberOfBalls; i++) {
            for (int j = 0; j < numberOfSlots; j++) {
                slots[i][j] = 0;
            }
        }
        return slots;
    }

    public static String generatesBallToDrop(int numberOfSlots) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfSlots - 1; i++) {
            int number = (int) (Math.random() * 2);
            if (number == 0) {
                result.append("L");
            } else {
                result.append("R");
            }
        }
        return result.toString();
    }
}

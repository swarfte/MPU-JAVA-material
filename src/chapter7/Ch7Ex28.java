package chapter7;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author swarfte
 * @title Math: permutations
 */
public class Ch7Ex28 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 4 numbers: ");
        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        permutations(numbers, stack);
    }

    public static void permutations(int[] numbers, Stack<Integer> stack) {
        permutations(numbers, numbers.length, 0, stack);
    }

    public static void permutations(int[] numbers, int target, int cur, Stack<Integer> stack) {

        // if all number in the stack
        if (target == cur) {
            System.out.println(stack);
            return;
        }


        for (int number : numbers) {

            // if not in the stack
            if (!stack.contains(number)) {
                stack.add(number);

                // find remain number
                permutations(numbers, target, cur + 1, stack);

                // to create new order
                stack.pop();
            }
        }
    }
}

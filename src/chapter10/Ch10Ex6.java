package chapter10;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display the prime numbers
 */
public class Ch10Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex6StackOfIntegers stack = new Ex6StackOfIntegers();
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        for (int i = 0; i < number; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


class Ex6StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    public Ex6StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public Ex6StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }


    public int peek() {
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}

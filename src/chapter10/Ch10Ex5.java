package chapter10;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display the prime factors
 */
public class Ch10Ex5 {
    public static void main(String[] args) {
        Ex6StackOfIntegers stack = new Ex6StackOfIntegers();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        for (int i = 2; i < number; ) {
            if (number % i == 0) {
                stack.push(i);
                number /= i;
            } else {
                i++;
            }
        }
        stack.push(number);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class Ex5StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    public Ex5StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public Ex5StackOfIntegers(int capacity) {
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
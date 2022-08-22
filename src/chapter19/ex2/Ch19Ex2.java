package chapter19.ex2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Implement GenericStack using inheritance
 */
public class Ch19Ex2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 strings: ");
        GenericStack<String> stack = new GenericStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(input.nextLine());
        }
        System.out.println(stack);

    }
}

/**
 * GenericStack<E> extends ArrayList<E>
 * <p>
 * + GenericStack<E>
 * <p>
 * + push(o: E) : void
 * <p>
 * + pop() : E
 * <p>
 * + peek() : E
 * <p>
 * + isEmpty() : boolean
 * <p>
 * + getSize() : int
 * <p>
 * + toString() : String
 */

class GenericStack<E> extends ArrayList<E> {
    GenericStack() {
        super();
    }

    public void push(E o) {
        add(o);
    }

    public E pop() {
        E o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public E peek() {
        return get(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getSize() {
        return size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(get(i));
            sb.append(" ");
        }
        sb.reverse();
        return sb.toString();
    }
}

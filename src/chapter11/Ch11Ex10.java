package chapter11;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Implement MyStack using inheritance
 */
public class Ch11Ex10 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

/**
 * UML diagram
 * <p>
 * MyStack
 * <p>
 * - list: ArrayList<Object>
 * <p>
 * + isEmpty(): Boolean
 * <p>
 * + getSize(): int
 * <p>
 * + peek(): Object
 * <p>
 * + pop(): Object
 * <p>
 * + push(Object): void
 */

class MyStack extends ArrayList<Object> {
    private ArrayList<Object> list = new ArrayList<Object>();


    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(list.size() - 1);
    }

    public Object pop() {
        return list.remove(list.size() - 1);
    }

    public void push(Object s) {
        list.add(s);
    }

}
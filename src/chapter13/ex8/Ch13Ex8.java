package chapter13.ex8;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Revise the MyStack class
 */
public class Ch13Ex8 {
    public static void main(String[] args) throws Exception {

    }
}

class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<Object>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public void push(Object o) {
        list.add(o);
    }

    public Object pop() {
        return list.remove(list.size() - 1);
    }

    public Object peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public String toString() {
        return "stack : " + list.toString();
    }

    public MyStack clone() {
        ArrayList<Object> newStack = (ArrayList<Object>) list.clone();
        MyStack newMyStack = new MyStack();
        newMyStack.list = newStack;
        return newMyStack;
    }
}
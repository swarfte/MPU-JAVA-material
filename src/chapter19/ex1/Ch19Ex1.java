package chapter19.ex1;

/**
 * @author swarfte
 * @title Revising Listing 19.1
 */
public class Ch19Ex1 {
    public static void main(String[] args) {

    }
}

class GenericStack<E> {
    private E[] list = (E[]) new Object[1];
    private int index = 0;

    public int getSize() {
        return list.length;
    }

    public E peek() {
        return list[getSize() - 1];
    }

    public void push(E o) {
        if (index == list.length) {
            E[] newList = (E[]) new Object[list.length * 2];
            for (int i = 0; i < list.length; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
        list[index] = o;
    }

    public E pop() {
        E o = list[index];
        list[index] = null;
        index--;
        return o;
    }


    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(list[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
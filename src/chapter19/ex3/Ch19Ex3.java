package chapter19.ex3;

/**
 * @author swarfte
 * @title Pair of objects of the same type
 */
public class Ch19Ex3 {
    public static void main(String[] args) {

    }
}

class Pair<E> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}
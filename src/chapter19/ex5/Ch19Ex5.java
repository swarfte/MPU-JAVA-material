package chapter19.ex5;

/**
 * @author swarfte
 * @title Inheritance between generic classes
 */
public class Ch19Ex5 {
    public static void main(String[] args) {
        Triplet<String> triplet = new Triplet<>("Hello", "World", "!");
    }
}

class Triplet<E> {
    private E first;
    private E second;
    private E third;

    public Triplet(E first, E second, E third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public void setThird(E third) {
        this.third = third;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E getThird() {
        return third;
    }
}

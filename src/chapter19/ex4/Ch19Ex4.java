package chapter19.ex4;

/**
 * @author swarfte
 * @title Using wildcards
 */
public class Ch19Ex4 {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("Hello", "World");
        System.out.println(smallestValue(pair));
    }

    public static <E> E smallestValue(Pair<? extends E> pair) {
        if (pair.getFirst() instanceof Comparable && pair.getSecond() instanceof Comparable) {
            if (((Comparable) pair.getFirst()).compareTo(pair.getSecond()) < 0) {
                return pair.getFirst();
            } else {
                return pair.getSecond();
            }
        } else {
            return null;
        }
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

    public void setFirst(E first) {
        this.first = first;
    }

    public void setSecond(E second) {
        this.second = second;
    }
}

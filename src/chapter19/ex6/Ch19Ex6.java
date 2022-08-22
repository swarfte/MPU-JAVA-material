package chapter19.ex6;

/**
 * @author swarfte
 * @title
 */
public class Ch19Ex6 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pair<Integer, Double> pair = new Pair<>(10, 20.0);
        Transition<Integer, Double, String> triplet = new Transition<>(10, 20.0, "Hello");
    }
}

class Pair<E1, E2> {
    private E1 e1;
    private E2 e2;

    public Pair(E1 e1, E2 e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public void setE1(E1 e1) {
        this.e1 = e1;
    }

    public void setE2(E2 e2) {
        this.e2 = e2;
    }

    public E1 getE1() {
        return e1;
    }
}

class Transition<E1, E2, E3> {
    private E1 e1;
    private E2 e2;
    private E3 e3;

    public Transition(E1 e1, E2 e2, E3 e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public void setFirst(E1 e1) {
        this.e1 = e1;
    }

    public void setSecond(E2 e2) {
        this.e2 = e2;
    }

    public void setThird(E3 e3) {
        this.e3 = e3;
    }

    public E1 getFirst() {
        return e1;
    }

    public E2 getSecond() {
        return e2;
    }

    public E3 getThird() {
        return e3;
    }
}

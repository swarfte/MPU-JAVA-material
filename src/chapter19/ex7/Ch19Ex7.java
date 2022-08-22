package chapter19.ex7;

/**
 * @author swarfte
 * @title Sum of an association
 */
public class Ch19Ex7 {
    public static void main(String[] args) {
        Transition<Integer, Double, Integer> triplet = new Transition<>(1, 2.3, 4);
        System.out.println(sum(triplet));
    }

    public static double sum(Transition<? extends Number, ? extends Number, ? extends Number> transactions) {
        return transactions.getFirst().doubleValue() + transactions.getSecond().doubleValue() + transactions.getThird().doubleValue();
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
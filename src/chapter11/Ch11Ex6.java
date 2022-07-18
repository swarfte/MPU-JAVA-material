package chapter11;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Use ArrayList
 */
public class Ch11Ex6 {
    public static void main(String[] args) {
        Object loan = new Loan();
        Object date = new Date();
        Object circle = new Circle();
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(loan);
        list.add(date);
        list.add(circle);
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}

class Loan {
    public String toString() {
        return "" + this.getClass().getName();
    }
}

class Date {
    public String toString() {
        return "" + this.getClass().getName();
    }
}

class Circle {
    public String toString() {
        return "" + this.getClass().getName();
    }
}
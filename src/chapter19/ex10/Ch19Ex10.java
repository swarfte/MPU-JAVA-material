package chapter19.ex10;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Smallest element in ArrayList
 */
public class Ch19Ex10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        System.out.println(list);
        System.out.println("Smallest element: " + min(list));
    }

    public static <E extends Comparable<E>> E min(ArrayList<E> list) {
        E currentMin = list.get(0);
        for (E e : list) {
            if (e.compareTo(currentMin) < 0) {
                currentMin = e;
            }
        }
        return currentMin;
    }
}

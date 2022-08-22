package chapter19.ex8;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Shuffle ArrayList
 */
public class Ch19Ex8 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }

    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = (int) (Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}

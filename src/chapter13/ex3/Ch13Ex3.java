package chapter13.ex3;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Sort ArrayList
 */
public class Ch13Ex3 {
    public static void main(String[] args) throws Exception {

    }

    public static void sort(ArrayList<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).doubleValue() < list.get(j).doubleValue()) {
                    Number temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
}

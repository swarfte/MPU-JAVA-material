package chapter13.ex2;

import java.util.ArrayList;

/**
 * @author swarfte
 * @title Average ArrayList
 */
public class Ch13Ex2 {
    public static void main(String[] args) {

    }

    public static void average(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println("Average: " + (double) sum / list.size());
    }
}

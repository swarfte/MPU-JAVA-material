package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Maximum element in ArrayList
 */
public class Ch11Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number in the ArrayList util enter 0: ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        int number;
        do {
            number = scanner.nextInt();
            if (number != 0) {
                arrayList.add(number);
            }
        } while (number != 0);
        System.out.println("The maximum element in the ArrayList is: " + max(arrayList));
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        Integer max = list.get(0);
        for (Integer i : list) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

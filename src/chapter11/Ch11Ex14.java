package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Combine two lists
 */
public class Ch11Ex14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        System.out.print("Enter five integers for list1 : ");
        for (int i = 0; i < 5; i++) {
            list1.add(scanner.nextInt());
        }
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        System.out.print("Enter five integers for list2 : ");
        for (int i = 0; i < 5; i++) {
            list2.add(scanner.nextInt());
        }

        ArrayList<Integer> combineList = union(list1, list2);
        System.out.print("The combined list is ");
        for (int i = 0; i < combineList.size(); i++) {
            System.out.print(combineList.get(i) + " ");
        }

    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < list1.size(); i++) {
            list.add(list1.get(i));
        }
        for (int i = 0; i < list2.size(); i++) {
            if (!list.contains(list2.get(i))) {
                list.add(list2.get(i));
            }
        }
        return list;
    }
}

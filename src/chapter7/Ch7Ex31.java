package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Merge two sorted lists
 */
public class Ch7Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter list1 size and contents : ");
        int[] list1 = new int[scanner.nextInt()];
        for (int i = 0; i < list1.length; i++) {
            list1[i] = scanner.nextInt();
        }

        System.out.print("Enter list2 size and contents : ");
        int[] list2 = new int[scanner.nextInt()];
        for (int i = 0; i < list2.length; i++) {
            list2[i] = scanner.nextInt();
        }

        System.out.print("list1 is ");
        for (int i = 0; i < list1.length; i++) {
            System.out.print(list1[i] + " ");
        }
        System.out.println();

        System.out.print("list2 is ");
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i] + " ");
        }
        System.out.println();

        int[] mergedList = merge(list1, list2);
        System.out.print("The Merged list is ");
        for (int i = 0; i < mergedList.length; i++) {
            System.out.print(mergedList[i] + " ");
        }
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] mergedList = new int[list1.length + list2.length];
        int i = 0, j = 0, k = 0;


        // to compare the list1 and list2 number
        while (i < list1.length && j < list2.length) {

            // if list1 number less then list2
            if (list1[i] < list2[j]) {
                mergedList[k] = list1[i];
                i++;
            } else {
                mergedList[k] = list2[j];
                j++;
            }
            k++;
        }

        // put remain number in the array
        while (i < list1.length) {
            mergedList[k] = list1[i];
            i++;
            k++;
        }
        while (j < list2.length) {
            mergedList[k] = list2[j];
            j++;
            k++;
        }
        return mergedList;
    }
}

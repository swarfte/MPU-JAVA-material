package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Partition of a list
 */
public class Ch7Ex32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int[] list = new int[scanner.nextInt()];
        System.out.print("Enter list content : ");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("After the partition , the list is : ");
        int[] sortedList = selectSort(list);
        for (int i = 0; i < sortedList.length; i++) {
            System.out.print(sortedList[i] + " ");
        }
    }

    public static int partition(int[] list) {
        int[] sortedList = selectSort(list);
        return sortedList.length / 2;
    }

    public static int[] selectSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        return list;
    }
}

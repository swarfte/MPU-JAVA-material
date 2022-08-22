package chapter19.ex12;

/**
 * @author swarfte
 * @title Revising Listing 23.4
 */
public class Ch19Ex12 {
    public static void main(String[] args) {
        Integer[] array = {4, 2, 6, 9, 8, 7, 55, 22, 3, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(array));
        bubbleSort(array);
        System.out.println("Sorted array: " + java.util.Arrays.toString(array));
    }

    public static <E extends Number> void bubbleSort(E[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].doubleValue() > list[i + 1].doubleValue()) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}

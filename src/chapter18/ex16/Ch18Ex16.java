package chapter18.ex16;

import java.util.Arrays;

/**
 * @author swarfte
 */
public class Ch18Ex16 {
    public static void main(String[] args) {
        int[] a = {8, 7, 4, 1, 9, 6, 2, 5, 3, 0};
        System.out.println(Arrays.toString(a));
        int k = pos(a, 2, 7);
        System.out.println(Arrays.toString(a));

    }

    public static int pos(int[] a, int l, int r) {
        int k = a[l];
        int[] temp = new int[r - l + 1];
        System.arraycopy(a, l, temp, 0, r + 1 - l);
        Arrays.sort(temp);
        for (int i = l; i < temp.length + l; i++) {
            a[i] = temp[i - l];
        }
        if (a[k] != k) {
            swap(a, k, a[k]);
        }
        return k;
    }


    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

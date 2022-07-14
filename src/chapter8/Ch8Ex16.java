package chapter8;

import java.util.Arrays;

/**
 * @author swarfte
 * @title Sort two-dimensional array
 */
public class Ch8Ex16 {
    public static void main(String[] args) {
        int[][] example = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};
        System.out.println("Before sorting:" + Arrays.deepToString(example));
        sort(example);
        System.out.println("After sorting:" + Arrays.deepToString(example));
    }

    public static void sort(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length - 1; j++) {
                if (m[j][0] < m[j + 1][0]) {
                    int[] temp = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = temp;
                } else if (m[j][0] == m[j + 1][0]) {
                    if (m[j][1] < m[j + 1][1]) {
                        int[] temp = m[j];
                        m[j] = m[j + 1];
                        m[j + 1] = temp;
                    }
                }
            }
        }
    }
}

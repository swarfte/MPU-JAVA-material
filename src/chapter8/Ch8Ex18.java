package chapter8;

import java.util.Arrays;

/**
 * @author swarfte
 * @title Shuffle rows
 */
public class Ch8Ex18 {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8},
                {9, 10}
        };
        shuffle(m);
        System.out.println(Arrays.deepToString(m));

    }

    public static void shuffle(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int first = (int) (Math.random() * m.length);
            int second = (int) (Math.random() * m.length);

            //shuffle the row
            int[] temp = Arrays.copyOf(m[first], m[first].length);
            m[first] = m[second];
            m[second] = temp;
        }
    }
}

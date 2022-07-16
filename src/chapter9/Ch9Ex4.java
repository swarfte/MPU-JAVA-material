package chapter9;

import java.util.Random;

/**
 * @author swarfte
 * @title Use the Random class
 */
public class Ch9Ex4 {
    public static void main(String[] args) {
        Random rand = new Random(1000);
        for (int i = 0; i < 50; i++) {
            System.out.println(rand.nextInt(100));
        }

    }
}


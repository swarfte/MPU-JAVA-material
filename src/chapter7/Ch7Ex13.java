package chapter7;

/**
 * @author swarfte
 * @title Random number selector
 */
public class Ch7Ex13 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("The random number is " + getRandom(numbers));
    }

    public static int getRandom(int... numbers) {
        return numbers[(int) (Math.random() * numbers.length)];
    }
}

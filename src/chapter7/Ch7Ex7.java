package chapter7;

/**
 * @author swarfte
 * @title Count single digits
 */
public class Ch7Ex7 {
    public static void main(String[] args) {
        int[] numbers = generatesRandomNumbers(200);
        int[] counts = countSingleDigits(numbers);
        for (int i = 0; i < counts.length; i++) {
            System.out.println("Number " + i + " count number " + ": " + counts[i]);
        }
    }

    public static int[] generatesRandomNumbers(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int) (Math.random() * 10);
        }
        return numbers;
    }

    public static int[] countSingleDigits(int[] numbers) {
        int[] counts = new int[10];
        for (int number : numbers) {
            counts[number]++;
        }
        return counts;
    }
}

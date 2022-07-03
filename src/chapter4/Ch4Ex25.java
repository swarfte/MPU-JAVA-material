package chapter4;

/**
 * @author swarfte
 * @title Generate vehicle plate numbers
 */

public class Ch4Ex25 {
    public static void main(String[] args) {
        char a = (char) (Math.random() * 26 + 65);
        char b = (char) (Math.random() * 26 + 65);
        char c = (char) (Math.random() * 26 + 65);
        int number = (int) (Math.random() * 10000);
        System.out.printf("The random vehicle plate number is %s", "" + a + b + c + number);
    }
}

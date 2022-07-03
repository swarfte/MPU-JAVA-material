package chapter4;

/**
 * @author swarfte
 * @title Random character
 */
public class Ch4Ex16 {
    public static void main(String[] args) {
        int number = (int) (Math.random() * 26 + 97);
        char character = (char) (number);
        System.out.print(character);
    }
}

package chapter3;

/**
 * @author swarfte
 * @title Random point
 */
public class Ch3Ex16 {
    public static void main(String[] args) {
        double x = Math.random() * 50;
        double y = Math.random() * 150;
        System.out.printf("The random coordinate in rectangle is (%f,%f)", x, y);
    }
}

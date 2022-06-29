package chapter1;

/**
 * @author swarfte
 * @title Area and perimeter of a circle
 */
public class Ch1Ex8 {
    public static void main(String[] args) {
        double pi = 3.14159;
        double radius = 6.5;
        double perimeter = 2 * pi * radius;
        double area = pi * radius * radius;
        System.out.println(perimeter);
        System.out.println(area);
    }
}

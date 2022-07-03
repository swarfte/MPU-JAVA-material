package chapter4;

/**
 * @author swarfte
 * @title Random points on a circle
 */
public class Ch4Ex6 {
    public static void main(String[] args) {
        double radius = 40;
        double x0 = Math.random() * radius;
        double y0 = Math.sqrt(Math.pow(radius, 2) - Math.pow(x0, 2));
        double x1 = Math.random() * radius;
        double y1 = Math.sqrt(Math.pow(radius, 2) - Math.pow(x1, 2));
        double x2 = Math.random() * radius;
        double y2 = Math.sqrt(Math.pow(radius, 2) - Math.pow(x2, 2));
        System.out.printf("Three random points on a circle is (%f , %f) , (%f , %f) , (%f , %f)", x0, y0, x1, y2, x2, y2);
    }
}

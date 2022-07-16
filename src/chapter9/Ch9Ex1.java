package chapter9;

/**
 * @author swarfte
 * @title The Rectangle class
 */
public class Ch9Ex1 {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        System.out.printf("The rectangle1 width is %.2f , height is %.2f area is %.2f and perimeter is %.2f\n", rectangle1.getWidth(), rectangle1.getHeight(), rectangle1.getArea(), rectangle1.getPerimeter());
        System.out.printf("The rectangle2 width is %.2f , height is %.2f area is %.2f and perimeter is %.2f\n", rectangle2.getWidth(), rectangle2.getHeight(), rectangle2.getArea(), rectangle2.getPerimeter());
    }
}

/**
 * UML diagram
 * <p>
 * Rectangle
 * <p>
 * -width: double
 * <p>
 * -height: double
 * <p>
 * +Rectangle()
 * <p>
 * +Rectangle(double width, double height)
 * <p>
 * + getWidth(): double
 * <p>
 * + getHeight(): double
 * <p>
 * + getArea(): double
 * <p>
 * + getPerimeter(): double
 */


class Rectangle {
    private double width = 1;
    private double height = 1;

    Rectangle() {
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width * height) / 2;
    }


}

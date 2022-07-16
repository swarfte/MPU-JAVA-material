package chapter9;

/**
 * @author swarfte
 * @title The Fan class
 */
public class Ch9Ex8 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setOn(true);
        fan1.setColor("yellow");

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setOn(false);
        fan2.setColor("blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

    }
}


/**
 * UML diagram
 * <p>
 * Fan
 * <p>
 * - speed: int = 1
 * <p>
 * - on: boolean = false
 * <p>
 * - radius: double = 5
 * <p>
 * - color: String = "blue"
 * <p>
 * + SLOW: int = 1{ReadOnly}
 * <p>
 * ___________________________
 * <p>
 * + MEDIUM: int = 2{ReadOnly}
 * <p>
 * ___________________________
 * <p>
 * + FAST : int = 3{ReadOnly}
 * <p>
 * ___________________________
 * <p>
 * + setSpeed(speed int): void
 * <p>
 * + getSpeed(): int
 * <p>
 * + isOn(): boolean
 * <p>
 * + setOn(on boolean): void
 * <p>
 * + setRadius(radius double): void
 * <p>
 * + getRadius(): double
 * <p>
 * + setColor(color String): void
 * <p>
 * + getColor(): String
 * <p>
 * + Fan()
 * <p>
 * + toString(): String
 */

class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = Fan.SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {

    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        if (this.on) {
            return "speed is " + this.speed + ", radius is " + this.radius + ", color is " + this.color;
        } else {
            return "radius is " + this.radius + ", color is " + this.color + ", fan is off";
        }
    }
}

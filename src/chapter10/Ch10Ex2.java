package chapter10;

/**
 * @author swarfte
 * @title The BMI class
 */
public class Ch10Ex2 {
    public static void main(String[] args) {
        BMI bmi = new BMI("a", 18, 18000, 2, 3);
        System.out.println(bmi.getBMI());
    }
}

/**
 * UML diagram
 * <p>
 * BMI
 * <p>
 * - name: String
 * <p>
 * - age: int
 * <p>
 * - weight: double
 * <p>
 * - feet: double
 * <p>
 * - inches: double
 * <p>
 * + BMI(name: String, age: int, weight: double, feet: double, inches: double)
 * <p>
 * + getName(): String
 * <p>
 * + getAge(): int
 * <p>
 * + getWeight(): double
 * <p>
 * + getFeet(): double
 * <p>
 * + getInches(): double
 * <p>
 * + setName(name: String): void
 * <p>
 * + setAge(age: int): void
 * <p>
 * + setWeight(weight: double): void
 * <p>
 * + setFeet(weight: double): void
 * <p>
 * + setInches(weight: double): void
 * <p>
 * + getBMI(): double
 */

class BMI {
    private String name;
    private int age;
    private double weight;
    private double height;
    private double feet;
    private double inches;

    public BMI(String name, int age, double weight, double feet, double inches) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.feet = feet;
        this.inches = inches;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getFeet() {
        return feet;
    }

    public double getInches() {
        return inches;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public double getBMI() {
        return weight / (feet * 12 + inches) / (feet * 12 + inches);
    }
}

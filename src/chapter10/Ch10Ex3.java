package chapter10;

/**
 * @author swarfte
 * @title The MyInteger class
 */
public class Ch10Ex3 {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(5);
        System.out.println(myInteger.isEven());
        System.out.println(myInteger.isOdd());
        System.out.println(myInteger.isPrime());
        System.out.println(myInteger.isEven());
        System.out.println(myInteger.isOdd());
        System.out.println(myInteger.isPrime());
    }
}


/**
 * UML diagram
 * <p>
 * MyInteger
 * <p>
 * - value: int
 * <p>
 * + MyInteger(value: int)
 * <p>
 * + getValue(): int
 * <p>
 * + isEven(): boolean
 * <p>
 * + isOdd(): boolean
 * <p>
 * + isPrime(): boolean
 * <p>
 * + isEven(value: int): boolean
 * <p>
 * ______________________________
 * <p>
 * + isOdd(value: int): boolean
 * <p>
 * _____________________________
 * <p>
 * + isPrime(value: int): boolean
 * <p>
 * _______________________________
 * <p>
 * + isEven(value: MyInteger): boolean
 * <p>
 * ____________________________________
 * <p>
 * + isOdd(value: MyInteger): boolean
 * <p>
 * _____________________________________
 * <p>
 * + isPrime(value: MyInteger): boolean
 * <p>
 * ______________________________________
 * <p>
 * + equals(value: int): boolean
 * <p>
 * + equals(value: MyInteger): boolean
 * <p>
 * + parseInt(value: String): int
 * <p>
 * ________________________________
 * <p>
 * + parseInt(value : char[]): int
 * <p>
 * ________________________________
 */
class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 == 1;
    }

    public boolean isPrime() {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    public static boolean isPrime(int value) {
        for (int i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger value) {
        return value.value % 2 == 0;
    }

    public static boolean isOdd(MyInteger value) {
        return value.value % 2 == 1;
    }

    public static boolean isPrime(MyInteger value) {
        for (int i = 2; i < value.value; i++) {
            if (value.value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger value) {
        return this.value == value.value;
    }

    public static int parseInt(String value) {
        return Integer.parseInt(value);
    }

    public static int parseInt(char[] value) {
        return Integer.parseInt(new String(value));
    }
}


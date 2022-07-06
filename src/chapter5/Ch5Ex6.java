package chapter5;

/**
 * @author swarfte
 * @title Conversion from square meter to ping
 */
public class Ch5Ex6 {
    public static void main(String[] args) {
        System.out.println("Ping      Square meter |  Square meter    Ping");
        for (int i = 10; i < 80; i += 5) {
            System.out.printf("%-10d %10f  |  %-15d %4f\n", i, i * 3.305, i + 20, (i + 20) / 3.305);
        }
    }
}

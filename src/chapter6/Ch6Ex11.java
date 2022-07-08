package chapter6;

/**
 * @author swarfte
 * @title Financial application: compute commissions
 */
public class Ch6Ex11 {
    public static void main(String[] args) {
        System.out.println("Sales Amount    Commission");
        System.out.println("-".repeat(40));
        int range = 100000;
        for (int i = 10000; i <= range; i += 5000) {
            System.out.printf("%-15d %f\n", i, computeCommission(i));
        }
    }

    public static double computeCommission(double salesAmount) {
        double money = 0;
        int level1 = 5000;
        int level2 = 10000;
        if (salesAmount <= level1) {
            money = salesAmount * 0.06;
        } else if (salesAmount <= level2) {
            money = level1 * 0.06 + (salesAmount - level1) * 0.08;
        } else {
            money = level1 * 0.06 + level1 * 0.08 + (salesAmount - level2) * 0.1;
        }
        return money;
    }
}

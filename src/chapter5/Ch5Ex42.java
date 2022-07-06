package chapter5;

/**
 * @author swarfte
 * @title Financial application : find the sales amount
 */
public class Ch5Ex42 {
    public static void main(String[] args) {
        int COMMISSION_SOUGHT = 30000;
        int amount = 0;
        double money = 0;
        int level1 = 5000;
        int level2 = 10000;
        while (money < COMMISSION_SOUGHT) {
            if (amount <= level1) {
                money = amount * 0.06;
            } else if (amount <= level2) {
                money = level1 * 0.06 + (amount - level1) * 0.08;
            } else {
                money = level1 * 0.06 + level1 * 0.08 + (amount - level2) * 0.1;
            }
            amount++;
        }
        System.out.println("The minimum sales is " + amount);
    }
}

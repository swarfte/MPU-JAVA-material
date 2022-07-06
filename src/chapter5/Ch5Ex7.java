package chapter5;

/**
 * @author swarfte
 * @title Financial application : compute future tuition
 */
public class Ch5Ex7 {
    public static void main(String[] args) {
        int year = 10;
        double tuition = 10000;
        double total = 0;
        for (int i = 0; i < year; i++) {
            total += tuition;
            tuition *= 1.06;
        }
        System.out.printf("The ten year tuition total is : %f \n", total);
        double afterTotal = 0;
        int afterYear = 4;
        for (int i = 0; i < afterYear; i++) {
            afterTotal += tuition;
            tuition *= 1.06;
        }
        System.out.printf("The total cost of four year worth of tuition after the tenth year is %f ", afterTotal);
    }
}

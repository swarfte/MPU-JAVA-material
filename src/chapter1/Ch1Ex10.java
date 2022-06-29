package chapter1;

/**
 * @author swarfte
 * @title Average speed in miles
 */
public class Ch1Ex10 {
    public static void main(String[] args) {
        double kilometers = 15;
        double time = 50 * 60 + 30;
        double hour = time / 3600;
        double mile = 1.6;
        double average = (kilometers / mile) / hour;
        System.out.println(average);
    }
}

package chapter1;

/**
 * @author swarfte
 */
public class Ex12 {
    public static void main(String[] args) {
        double miles = 24;
        double time = 60 * 60 + 40 * 60 + 60;
        double kilometers = 1.6;
        double average = (miles * kilometers) / (time / 3600);
        System.out.println(average);
    }
}

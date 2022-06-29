package chapter1;

/**
 * @author swarfte
 * @title population projection
 */
public class Ch1Ex11 {
    public static void main(String[] args) {
        int population = 312032486;
        int day = 365;
        int time = 365 * 24 * 60 * 60;
        int birth = time / 7;
        int death = time / 13;
        int immigrant = time / 45;

        for (int year = 1; year <= 5; year++) {
            population = population + birth + immigrant - death;
            System.out.printf("the %d year : %d people \n", year, population);
        }
    }
}

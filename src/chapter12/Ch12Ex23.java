package chapter12;

import java.util.ArrayList;
import java.util.Scanner;
import java.net.URL;

/**
 * @author swarfte
 * @title Process scores in a text file on the Web
 */
public class Ch12Ex23 {
    public static void main(String[] args) throws Exception {
        String urlString = args[0];
        try {
            URL url = new URL(urlString);
            Scanner input = new Scanner(url.openStream());
            ArrayList<Integer> scores = new ArrayList<>();
            while (input.hasNext()) {
                scores.add(input.nextInt());
            }
            System.out.println("The average score is " + average(scores));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double average(ArrayList<Integer> scores) {
        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        return (double) sum / scores.size();
    }
}

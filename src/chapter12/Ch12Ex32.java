package chapter12;

import java.net.URL;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Ranking summary
 */
public class Ch12Ex32 {
    public static void main(String[] args) throws Exception {
        int startYear = 2010;
        int endYear = 2001;

        System.out.println("_".repeat(100));
        System.out.print("Year ");
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("Rank %d ", j);
            }
        }
        System.out.println();
        System.out.println("_".repeat(100));
        for (int year = startYear; year >= endYear; year--) {
            String link = "https://liveexample.pearsoncmg.com/data/babynamesranking" + year + ".txt";
            URL url = new URL(link);
            int count = 0;
            String[][] topFive = new String[5][2];
            try (Scanner data = new Scanner(url.openStream())) {
                while (data.hasNext() && count < topFive.length) {
                    for (int i = 0; i < topFive.length; i++) {
                        String temp = data.next();
                        if (i == 1) {
                            topFive[count][0] = temp;
                        } else if (i == 3) {
                            topFive[count][1] = temp;
                        }
                    }
                    count++;
                }
            }
            System.out.printf("%d ", year);
            for (int i = 1; i >= 0; i--) {
                for (String[] strings : topFive) {
                    System.out.printf("%-8s ", strings[i]);
                }
            }
            System.out.println();
        }
    }
}

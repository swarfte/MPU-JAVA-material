package chapter12;

import java.util.Scanner;
import java.net.URL;

/**
 * @author swarfte
 * @title Baby name popularity ranking
 */
public class Ch12Ex31 {
    public static void main(String[] args) throws Exception {
        String link = "https://liveexample.pearsoncmg.com/data/babynamesranking";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year : ");
        int year = scanner.nextInt();
        System.out.print("Enter the gender : ");
        String gender = scanner.next();
        int checkGender = "M".equals(gender) ? 1 : 3;
        System.out.print("Enter the name : ");
        String name = scanner.next();
        link += year + ".txt";
        URL url = new URL(link);
        Scanner data = new Scanner(url.openStream());
        boolean found = false;
        while (data.hasNext()) {
            String[] temp = new String[5];
            for (int i = 0; i < 5; i++) {
                temp[i] = data.next();
            }
            if (temp[checkGender].equals(name)) {
                System.out.printf("%s is ranked #%d in year %d", name, Integer.parseInt(temp[0]), year);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.printf("The name %s is not ranked in year %d", name, year);
        }
    }
}

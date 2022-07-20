package chapter12;

import java.io.File;
import java.io.PrintWriter;

/**
 * @author swarfte
 * @title Create large dataset
 */
public class Ch12Ex24 {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        File file = new File(fileName);
        try (PrintWriter output = new PrintWriter(file)) {
            output.print("");
            for (int i = 1; i <= 1000; i++) {
                output.println(generateMember(i));
            }
        }
    }

    public static String generateMember(int i) {
        String[] rank = {"assistant", "associate", "full"};
        int randomNumber = (int) (Math.random() * 3);
        double[] salary = {50000 + (int) (Math.random() * 30001),
                60000 + (int) (Math.random() * 50001),
                75000 + (int) (Math.random() * 55001)};
        return String.format("FirstName%d LastName%d %s %.2f", i, i, rank[randomNumber], salary[randomNumber]);
    }
}

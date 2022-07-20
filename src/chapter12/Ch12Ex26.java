package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Create a directory
 */
public class Ch12Ex26 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory name: ");
        String dirName = scanner.nextLine();
        String dirPathName = "src/chapter12/" + dirName;
        File dir = new File(dirPathName);
        if (dir.exists()) {
            System.out.println("Directory already exists.");
        } else {
            boolean check = dir.mkdir();
            System.out.println("Directory created.");
        }

    }
}

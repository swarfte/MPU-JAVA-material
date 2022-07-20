package chapter12;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * @author swarfte
 * @title Reading in a sorted file
 */
public class Ch12Ex14 {
    public static void main(String[] args) throws Exception {
        File file = new File(args[1]);
        System.out.println(readInFile(args[0], file));
    }


    public static int readInFile(String name, File file) throws FileNotFoundException {
        int index = -1;
        ArrayList<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
            }
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).contains(name)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

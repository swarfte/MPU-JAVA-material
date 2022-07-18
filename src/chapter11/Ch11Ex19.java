package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Bin packing using first fit
 */
public class Ch11Ex19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int numberOfObjects = scanner.nextInt();
        ArrayList<Integer> objects = new ArrayList<Integer>();
        System.out.print("Enter the weight of object : ");
        for (int i = 0; i < numberOfObjects; i++) {
            objects.add(scanner.nextInt());
        }
        int limit = 10;
        int people = 1;
        while (objects.size() > 0) {
            int count = 0;
            ArrayList<Integer> currentBin = new ArrayList<Integer>();
            for (int i = 0; i < objects.size(); i++) {
                if (count + objects.get(i) <= limit) {
                    count += objects.get(i);
                    currentBin.add(objects.get(i));
                    objects.remove(i);
                    i--;
                }
            }
            System.out.print("Container " + people + " contains objects with weight ");
            for (int i = 0; i < currentBin.size(); i++) {
                System.out.print(currentBin.get(i) + " ");
            }
            System.out.println();
            people++;
        }

    }
}

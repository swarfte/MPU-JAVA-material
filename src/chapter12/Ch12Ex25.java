package chapter12;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Process large dataset
 */
public class Ch12Ex25 {
    public static void main(String[] args) throws Exception {
        String URLString = args[0];
        try {
            URL url = new URL(URLString);
            Scanner input = new Scanner(url.openStream());
            ArrayList<Double> assistantProfessors = new ArrayList<>();
            ArrayList<Double> associateProfessors = new ArrayList<>();
            ArrayList<Double> fullProfessors = new ArrayList<>();

            while (input.hasNext()) {
                int index = -1;
                for (int i = 0; i < 4; i++) {
                    String data = input.next();
                    if (i == 2) {
                        if (data.contains("assistant")) {
                            index = 0;
                        } else if (data.contains("associate")) {
                            index = 1;
                        } else if (data.contains("full")) {
                            index = 2;
                        }
                    } else if (i == 3) {
                        if (index == 0) {
                            assistantProfessors.add(Double.parseDouble(data));
                        } else if (index == 1) {
                            associateProfessors.add(Double.parseDouble(data));
                        } else if (index == 2) {
                            fullProfessors.add(Double.parseDouble(data));
                        }
                    }
                }
            }
            System.out.println("The total salary of assistant professors is " + totalSalary(assistantProfessors));
            System.out.println("The average salary of assistant professors is " + average(assistantProfessors));
            System.out.println("The total salary of associate professors is " + totalSalary(associateProfessors));
            System.out.println("The average salary of associate professors is " + average(associateProfessors));
            System.out.println("The total salary of full professors is " + totalSalary(fullProfessors));
            System.out.println("The average salary of full professors is " + average(fullProfessors));
            System.out.println("The total salary of faculty is " + (totalSalary(assistantProfessors) + totalSalary(associateProfessors) + totalSalary(fullProfessors)));
            System.out.println("The average salary of faculty is " + (average(assistantProfessors) + average(associateProfessors) + average(fullProfessors)) / 3);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double average(ArrayList<Double> scores) {
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    public static double totalSalary(ArrayList<Double> scores) {
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return sum;
    }
}

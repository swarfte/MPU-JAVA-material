package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the highest score
 */
public class Ch5Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of student : ");
        int numberOfStudent = scanner.nextInt();
        String studentName = "";
        double score = 0.0;
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.print("Enter the student's name : ");
            String tempStudentName = scanner.next();
            System.out.print("Enter the student's score : ");
            double tempStudentScore = scanner.nextDouble();
            if (tempStudentScore > score) {
                score = tempStudentScore;
                studentName = tempStudentName;
            }
        }
        System.out.println("The highest score student is " + studentName + ", score is " + score);
    }

}

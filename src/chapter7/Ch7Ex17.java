package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sort students
 */
public class Ch7Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int studentNumber = scanner.nextInt();
        String[] studentName = new String[studentNumber];
        double[] studentScore = new double[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentName[i] = scanner.next();
            System.out.print("Enter the score of student " + (i + 1) + ": ");
            studentScore[i] = scanner.nextDouble();
        }

        selectSort(studentName, studentScore);
        reverse(studentName, studentScore);
        for (int i = 0; i < studentNumber; i++) {
            System.out.println("Student " + studentName[i] + " score : " + studentScore[i]);
        }

    }

    public static void reverse(String[] studentName, double[] studentScore) {
        for (int i = 0, j = studentName.length - 1; i < j; i++, j--) {
            String temp = studentName[i];
            studentName[i] = studentName[j];
            studentName[j] = temp;
            double temp2 = studentScore[i];
            studentScore[i] = studentScore[j];
            studentScore[j] = temp2;
        }
    }

    public static void selectSort(String[] studentName, double[] studentScore) {
        for (int i = 0; i < studentName.length; i++) {
            int minIndex = i;

            // to find the minimum value in the array
            for (int j = i + 1; j < studentName.length; j++) {
                if (studentScore[j] < studentScore[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the minimum value with the current index
            String tempName = studentName[i];
            studentName[i] = studentName[minIndex];
            studentName[minIndex] = tempName;

            double tempScore = studentScore[i];
            studentScore[i] = studentScore[minIndex];
            studentScore[minIndex] = tempScore;

        }
    }
}

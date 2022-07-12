package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Assign grades
 */
public class Ch7Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = scanner.nextInt();
        int[] score = new int[students];
        System.out.printf("Enter %d scores : ", students);
        for (int i = 0; i < students; i++) {
            score[i] = scanner.nextInt();
        }
        char[] grade = assignGrades(score);
        for (int i = 0; i < students; i++) {
            System.out.printf("Student %d score is %d and grade is %c\n", i, score[i], grade[i]);
        }
    }

    public static char[] assignGrades(int[] grades) {
        int best = -1;
        for (int i : grades) {
            if (i > best) {
                best = i;
            }
        }
        char[] score = new char[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= best - 5) {
                score[i] = 'A';
            } else if (grades[i] >= best - 10) {
                score[i] = 'B';
            } else if (grades[i] >= best - 15) {
                score[i] = 'C';
            } else if (grades[i] >= best - 20) {
                score[i] = 'D';
            } else {
                score[i] = 'F';
            }
        }

        return score;
    }
}

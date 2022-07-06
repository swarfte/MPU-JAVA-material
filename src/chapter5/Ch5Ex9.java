package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title find the two lowest scores
 */
public class Ch5Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of student : ");
        int numberOfStudent = scanner.nextInt();
        String[] studentNames = new String[numberOfStudent];
        double[] studentScores = new double[numberOfStudent];
        for (int i = 0; i < numberOfStudent; i++) {
            System.out.print("Enter the student's name : ");
            studentNames[i] = scanner.next();
            System.out.print("Enter the student's score : ");
            studentScores[i] = scanner.nextDouble();
        }
        String lowestName = studentNames[findTheLowestScore(studentScores)];
        double lowestScore = studentScores[findTheLowestScore(studentScores)];
        System.out.printf(" The lowest score student is %s , score is %f\n", lowestName, lowestScore);
        studentScores[(findTheLowestScore(studentScores))] = 2147483647;
        lowestName = studentNames[findTheLowestScore(studentScores)];
        lowestScore = studentScores[findTheLowestScore(studentScores)];
        System.out.printf(" The second lowest score student is %s , score is %f\n", lowestName, lowestScore);
    }

    public static int findTheLowestScore(double[] scores) {
        double lowestScore = 2147483647;
        int lowestScoreIndex = -1;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < lowestScore) {
                lowestScoreIndex = i;
                lowestScore = scores[i];
            }
        }
        return lowestScoreIndex;
    }
}

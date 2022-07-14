package chapter8;

import java.util.Arrays;

/**
 * @author swarfte
 * @title Sort students on grades
 */
public class Ch8Ex3 {
    public static void main(String[] args) {
        int studentNumber = 8;
        int answerNumber = 10;
        char[][] answers = new char[studentNumber][];
        int[] order = new int[studentNumber];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        for (int i = 0; i < answers.length; i++) {
            answers[i] = generateAnswer(answerNumber);
        }
        char[] keys = generateAnswer(answerNumber);
        int[] count = new int[answers.length];
        for (int i = 0; i < answers.length; i++) {
            count[i] = checkAnswer(answers[i], keys);
        }
        for (int i = 0; i < answers.length; i++) {
            System.out.println("Student " + order[i] + "'s answer " + ": " + Arrays.toString(answers[i]));
        }
        System.out.println("Keys: " + Arrays.toString(keys));

        sort(answers, count, order);
        for (int i = 0; i < count.length; i++) {
            System.out.println("Student " + order[i] + "'s correct count is " + count[i]);
        }


    }

    public static void sort(char[][] answers, int[] count, int[] order) {
        for (int i = 0; i < answers.length; i++) {
            for (int j = i + 1; j < answers.length; j++) {
                // if the nex value then current value
                if (count[i] < count[j]) {

                    char[] temp = answers[i];
                    answers[i] = answers[j];
                    answers[j] = temp;

                    int tempCount = count[i];
                    count[i] = count[j];
                    count[j] = tempCount;

                    int tempOrder = order[i];
                    order[i] = order[j];
                    order[j] = tempOrder;
                }
            }
        }
    }

    public static int checkAnswer(char[] keys, char[] answer) {
        int count = 0;
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == keys[i]) {
                count++;
            }
        }
        return count;
    }

    public static char[] generateAnswer(int answerNumber) {
        char[] answer = new char[answerNumber];
        for (int i = 0; i < answerNumber; i++) {

            // generate a random value from a to d
            answer[i] = (char) ('A' + (int) (Math.random() * 4));
        }
        return answer;
    }
}

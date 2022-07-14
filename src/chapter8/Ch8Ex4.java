package chapter8;

/**
 * @author swarfte
 * @title Compute the weekly hours for each employee
 */
public class Ch8Ex4 {
    public static void main(String[] args) {
        int employee = 8;
        int day = 7;
        int[][] workTable = getWeeklyHours(employee, day);
        int[] order = new int[employee];
        for (int i = 0; i < employee; i++) {
            order[i] = i;
        }
        int[] total = new int[employee];
        for (int i = 0; i < employee; i++) {
            total[i] = totalHours(workTable[i]);
        }

        for (int i = 0; i < workTable.length; i++) {
            for (int j = 0; j < workTable[i].length; j++) {
                System.out.print(workTable[i][j] + " ");
            }
            System.out.println();
        }

        sort(order, total);
        for (int i = 0; i < employee; i++) {
            System.out.println("Employee " + order[i] + " has " + total[i] + " hours");
        }

    }

    public static void sort(int[] order, int[] total) {
        for (int i = 0; i < order.length; i++) {
            for (int j = 0; j < order.length - 1; j++) {
                if (total[j] < total[j + 1]) {
                    int temp = total[j];
                    total[j] = total[j + 1];
                    total[j + 1] = temp;
                    int temp2 = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp2;
                }
            }
        }
    }

    public static int totalHours(int[] hours) {
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i];
        }
        return sum;
    }

    public static int[][] getWeeklyHours(int employee, int day) {
        int[][] workTable = new int[employee][day];
        for (int i = 0; i < employee; i++) {
            for (int j = 0; j < day; j++) {
                workTable[i][j] = (int) (Math.random() * 9 + 1);
            }
        }
        return workTable;
    }
}

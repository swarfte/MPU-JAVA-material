package chapter7;

/**
 * @author swarfte
 * @title Game: locker puzzle
 */
public class Ch7Ex23 {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[100];
        boolean[] result = lockerPuzzle(lockers);
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }

    }

    public static boolean[] lockerPuzzle(boolean[] lockers) {
        return lockerPuzzle(lockers, 0, 100);
    }

    public static boolean[] lockerPuzzle(boolean[] lockers, int student, int number) {

        // index 0 is Student 1
        if (student == 0) {
            for (int i = student; i < lockers.length; i++) {
                lockers[i] = true;
            }
            return lockerPuzzle(lockers, student + 1, number);
        } else if (student == 1) {
            for (int i = student; i < lockers.length; i++) {
                lockers[i] = false;
            }
            return lockerPuzzle(lockers, student + 1, number);
        } else if (student < number) {
            for (int i = student; i < lockers.length; i += student) {
                lockers[i] = !lockers[i];
            }
            return lockerPuzzle(lockers, student + 1, number);
        }
        return lockers;
    }
}

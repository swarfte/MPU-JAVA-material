package chapter9;

/**
 * @author swarfte
 */
public class Ch9Ex6 {
    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length);
        }
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        selectSort(array);
        stopwatch.stop();
        System.out.println("The time for selection sort is " + stopwatch.getElapsedTime() / 1000 + " seconds");

    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

/**
 * UML diagram
 * <p>
 * Stopwatch
 * <p>
 * - startTime: long
 * <p>
 * - endTime: long
 * <p>
 * + Stopwatch()
 * <p>
 * + getStartTime(): long
 * <p>
 * + getEndTime(): long
 * <p>
 * + start(): void
 * <p>
 * + stop(): void
 * <p>
 * + getElapsedTime(): long
 */

class Stopwatch {
    private long startTime;
    private long endTime;

    public Stopwatch() {
        startTime = System.currentTimeMillis();
        ;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

}
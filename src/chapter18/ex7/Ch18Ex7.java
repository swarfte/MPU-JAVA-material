package chapter18.ex7;


/**
 * @author swarfte
 * @title Fibonacci series
 */
public class Ch18Ex7 {
    public static long runTime = 0;

    public static void main(String[] args) {
        System.out.println("Fibonacci number: " + fib(20));
        System.out.println("Run time: " + runTime);
    }

    public static long fib(long index) {
        runTime++;
        if (index == 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            return fib(index - 1) + fib(index - 2);
        }
    }
}

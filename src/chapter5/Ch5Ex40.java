package chapter5;

/**
 * @author swarfte
 * @title Simulation: head or tail
 */
public class Ch5Ex40 {
    public static void main(String[] args) {
        int head = 0;
        int tail = 0;
        int time = 2000000;
        for (int i = 0; i < time; i++) {
            if ((int) (Math.random() * 2) == 0) {
                head++;
            } else {
                tail++;
            }
        }
        System.out.printf("The number of heads is %d and the number of tail is %d", head, tail);
    }
}

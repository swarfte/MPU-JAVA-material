package chapter18.ex18;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Tower of Hanoi
 */
public class Ch18Ex18 {
    public static int moves = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("the number of moves is " + moves);
    }

    public static void moveDisks(int n, char fromTower, char auxTower, char toTower) {
        if (n == 1) {
            moves++;
            //step 2 move the largest disk from fromTower(a) to toTower(c)
            //System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            //step 1 move n - 1 disks from fromTower(a) to auxTower(b)
            moveDisks(n - 1, fromTower, toTower, auxTower);
            moves++;
            //System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            //step 3 move n - 1 disks from auxTower(b) to toTower(c)
            moveDisks(n - 1, auxTower, fromTower, toTower);
        }
    }

}

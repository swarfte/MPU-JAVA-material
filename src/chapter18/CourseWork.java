package chapter18;

public class CourseWork {
    public static void main(String[] args) throws Exception {
        System.out.println(powerOfX(2, 4));
    }

    public static int powerOfX(int x, int n) {
        if (n == 1) {
            return 2;
        } else if (n == 0) {
            return 1;
        } else {
            return x * powerOfX(x, n - 1);
        }
    }

    public static int sumOfX(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x + sumOfX(x - 1);
        }
    }

    public static void moveDisks(int n, char fromTower, char auxTower, char toTower) {
        if (n == 1) {
            //step 2 move the largest disk from fromTower(a) to toTower(c)
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            //step 1 move n - 1 disks from fromTower(a) to auxTower(b)
            moveDisks(n - 1, fromTower, toTower, auxTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            //step 3 move n - 1 disks from auxTower(b) to toTower(c)
            moveDisks(n - 1, auxTower, fromTower, toTower);
        }
    }


}

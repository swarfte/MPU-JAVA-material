package chapter8;

/**
 * @author swarfte
 * @title Points nearest each other
 */
public class Ch8Ex7 {
    public static void main(String[] args) {
        double[][] points = {
                {-1, 0, 3}, {-1, -1, -1}, {4, 1, 1},
                {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3},
                {-1.5, 4, 2}, {5.5, 4, -0.5}
        };

        int[] minIndex = new int[2];
        double distance = getDistance(points[0][0], points[0][1], points[0][2],
                points[1][0], points[1][1], points[1][2]);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (i != j) {
                    double temp = getDistance(points[i][0], points[i][1], points[i][2],
                            points[j][0], points[j][1], points[j][2]);
                    if (temp < distance) {
                        distance = temp;
                        minIndex[0] = i;
                        minIndex[1] = j;
                    }
                }
            }
        }

        System.out.println("The points nearest each other are: ");
        System.out.printf("(%.2f, %.2f, %.2f) and (%.2f, %.2f, %.2f)\n", points[minIndex[0]][0], points[minIndex[0]][1], points[minIndex[0]][2],
                points[minIndex[1]][0], points[minIndex[1]][1], points[minIndex[1]][2]);
    }

    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        double a = Math.pow(x2 - x1, 2);
        double b = Math.pow(y2 - y1, 2);
        double c = Math.pow(z2 - z1, 2);
        return Math.sqrt(a + b + c);
    }
}

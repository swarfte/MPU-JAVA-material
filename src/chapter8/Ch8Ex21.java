package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Central city
 */
public class Ch8Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int numberOfCities = scanner.nextInt();
        double[][] cityPoint = new double[numberOfCities][2];
        System.out.println("Enter the coordinates of the cities :");
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < cityPoint[i].length; j++) {
                cityPoint[i][j] = scanner.nextDouble();
            }
        }
        double[][] cityDistance = new double[numberOfCities][numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                cityDistance[i][j] = getDistance(cityPoint[i][0], cityPoint[i][1], cityPoint[j][0], cityPoint[j][1]);
            }
        }
        double[] totalDistance = new double[numberOfCities];
        for (int i = 0; i < numberOfCities; i++) {
            for (int j = 0; j < numberOfCities; j++) {
                if (i != j) {
                    totalDistance[i] += cityDistance[i][j];
                }
            }
        }
        int centralCityIndex = findTheCentralCity(totalDistance);
        System.out.printf("The central city is at (%.2f , %.2f)\n", cityPoint[centralCityIndex][0], cityPoint[centralCityIndex][1]);
        System.out.printf("THe total distance to all other cities is %.2f\n", totalDistance[centralCityIndex]);
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static int findTheCentralCity(double[] totalDistance) {
        int centralCity = 0;
        double minDistance = totalDistance[0];
        for (int i = 0; i < totalDistance.length; i++) {
            if (totalDistance[i] < minDistance) {
                minDistance = totalDistance[i];
                centralCity = i;
            }
        }
        return centralCity;
    }
}

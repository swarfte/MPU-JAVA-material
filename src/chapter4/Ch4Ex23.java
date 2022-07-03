package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : payroll
 */
public class Ch4Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee's name : ");
        String employeeName = scanner.next();
        System.out.print("Enter number  of hours worked in a week : ");
        double numberOfHours = scanner.nextDouble();
        System.out.print("Enter hourly pay rate : ");
        double payRate = scanner.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        double federalTaxRate = scanner.nextDouble();
        System.out.print("Enter state tax withholding rate : ");
        double stateTarRate = scanner.nextDouble();
        System.out.println();

        System.out.printf("Employee Name : %s \n ", employeeName);
        System.out.printf("Hour Worked : %f \n", numberOfHours);
        System.out.printf("Pay Rate : $%f \n", payRate);
        System.out.printf("Gross Pay : $%f \n", numberOfHours * payRate);
        System.out.println("Deductions");
        double federalWithholding = numberOfHours * payRate * federalTaxRate;
        System.out.printf("  Federal Withholding (%f%%) : $%f \n", federalTaxRate * 100, federalWithholding);
        double stateWithholding = numberOfHours * payRate * stateTarRate;
        System.out.printf("  State Withholding (%f%%) : $%f \n", stateWithholding * 100, stateWithholding);
        System.out.printf("  Total Deduction : $%f \n", federalWithholding + stateWithholding);
        System.out.printf("Net Pay : $%f\n", numberOfHours * payRate - federalWithholding - stateWithholding);
    }
}

import java.util.Scanner;

public class PaycheckOvertime_Starter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Named constants
        final int OVERTIME_THRESHOLD = 40;
        final double OVERTIME_MULTIPLIER = 1.5;

        // User inputs
        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter hours worked: ");
        double hours = input.nextDouble();

        System.out.print("Enter hourly rate: ");
        double rate = input.nextDouble();

        System.out.print("Enter retirement contribution percentage: ");
        int percent = input.nextInt();

        System.out.print("Print detailed pay stub? (Y/N): ");
        char printStub = input.next().charAt(0);

        // Validation
        if (hours < 0 || rate < 0 || percent < 0 || percent > 100) {
            System.out.println("Error: Invalid input values.");
            return;
        }

        // Calculations
        double regularHours = Math.min(hours, OVERTIME_THRESHOLD);
        double overtimeHours = Math.max(hours - OVERTIME_THRESHOLD, 0);

        double grossPay = (regularHours * rate) +
                (overtimeHours * rate * OVERTIME_MULTIPLIER);

        double retirementDeduction = grossPay * (percent / 100.0); // type conversion
        double netPay = grossPay - retirementDeduction;

        // Output
        if (printStub == 'Y' || printStub == 'y') {
            System.out.printf("\n--- Weekly Pay Stub for %s ---\n", name);
            System.out.printf("Regular Hours: %.2f\n", regularHours);
            System.out.printf("Overtime Hours: %.2f\n", overtimeHours);
            System.out.printf("Gross Pay: $%.2f\n", grossPay);
            System.out.printf("Retirement Deduction: $%.2f\n", retirementDeduction);
            System.out.printf("Net Pay: $%.2f\n", netPay);
        } else {
            System.out.printf("\nNet Pay for %s: $%.2f\n", name, netPay);
        }

        input.close();
    }
}

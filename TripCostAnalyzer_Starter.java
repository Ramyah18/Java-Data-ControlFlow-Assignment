import java.util.Scanner;

public class TripCostAnalyzer_Starter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Named constant (example requirement)
        final double MIN_MPG = 1.0; // Minimum allowed MPG to avoid division errors

        // User inputs
        System.out.print("Enter distance in miles: ");
        double distance = input.nextDouble();

        System.out.print("Enter vehicle fuel efficiency (mpg): ");
        double mpg = input.nextDouble();

        System.out.print("Enter price per gallon: ");
        double price = input.nextDouble();

        System.out.print("Enter number of passengers: ");
        int passengers = input.nextInt();

        // Validate inputs
        if (distance <= 0) {
            System.out.println("Error: Distance must be greater than 0.");
            return;
        }

        if (mpg < MIN_MPG) {
            System.out.println("Error: MPG must be greater than " + MIN_MPG);
            return;
        }

        if (price < 0) {
            System.out.println("Error: Price per gallon cannot be negative.");
            return;
        }

        // Calculations
        double gallonsNeeded = distance / mpg; // double chosen for precision
        double totalFuelCost = gallonsNeeded * price;
        double costPerMile = totalFuelCost / distance;

        // Output
        System.out.printf("\n--- Trip Cost Summary ---\n");
        System.out.printf("Gallons Needed: %.2f\n", gallonsNeeded);
        System.out.printf("Total Fuel Cost: $%.2f\n", totalFuelCost);
        System.out.printf("Cost Per Mile: $%.2f\n", costPerMile);

        if (passengers > 0) {
            double costPerPassenger = totalFuelCost / passengers;
            System.out.printf("Cost Per Passenger: $%.2f\n", costPerPassenger);
        } else {
            System.out.println("Cost Per Passenger: N/A (invalid passenger count)");
        }

        input.close();
    }
}

package week2.day2.assignment1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ElectricityBillApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String consumerNumber = "";
		String consumerName = "";
		double previousReading = 0;
		double currentReading = 0;
		double unitsConsumed = 0;

		// Consumer number must not be empty.
		while (true) {
			System.out.print("Enter consumer number: ");
			consumerNumber = scanner.nextLine().trim();

			if (!consumerNumber.isEmpty()) {
				break;
			}
			System.out.println("Error: Consumer number cannot be empty. Please re-enter.");
		}

		// Consumer name must not be empty.
		while (true) {
			System.out.print("Enter consumer name: ");
			consumerName = scanner.nextLine().trim();

			if (!consumerName.isEmpty()) {
				break;
			}
			System.out.println("Error: Consumer name cannot be empty. Please re-enter.");
		}

		// Readings are re-entered until the meter readings are valid.
		while (true) {
			previousReading = readNonNegativeDouble(scanner, "Enter previous meter reading: ");
			currentReading = readNonNegativeDouble(scanner, "Enter current meter reading: ");

			if (currentReading < previousReading) {
				System.out.println("Error: Bill rejected. Current meter reading cannot be less than previous meter reading.");
				System.out.println("Please re-enter both meter readings.");
			} else {
				unitsConsumed = currentReading - previousReading;
				break;
			}
		}

		// Calculate energy charge according to the slab rates.
		double energyCharge = calculateEnergyCharge((int) unitsConsumed);

		// Fixed charge and conditional surcharge.
		double fixedCharge = 50.00;
		double surcharge = calculateSurcharge(energyCharge);
		double totalAmount = calculateTotal(energyCharge);

		printBill(consumerNumber, consumerName, previousReading, currentReading,
				unitsConsumed, energyCharge, fixedCharge, surcharge, totalAmount);

		scanner.close();
	}

	/**
	 * Calculates the energy charge using the slab rates for an integer number
	 * of units consumed.
	 */
	public static double calculateEnergyCharge(int units) {
		if (units < 0) {
			throw new IllegalArgumentException("Units consumed cannot be negative.");
		}
		if (units <= 100) {
			return units * 3.00;
		} else if (units <= 300) {
			return (100 * 3.00) + ((units - 100) * 5.00);
		} else {
			return (100 * 3.00) + (200 * 5.00) + ((units - 300) * 7.50);
		}
	}

	/**
	 * Calculates a 5% surcharge when the energy charge is above ₹2,000.
	 */
	public static double calculateSurcharge(double energyCharge) {
		if (energyCharge > 2000.00) {
			return energyCharge * 0.05;
		}
		return 0.00;
	}

	/**
	 * Calculates the final bill amount by adding the fixed charge and surcharge
	 * to the energy charge.
	 */
	public static double calculateTotal(double energyCharge) {
		return energyCharge + 50.00 + calculateSurcharge(energyCharge);
	}

	/**
	 * Prints the consumer details, meter readings, charges, and total bill.
	 */
	public static void printBill(String consumerNumber, String consumerName,
			double previousReading, double currentReading, double unitsConsumed,
			double energyCharge, double fixedCharge, double surcharge, double totalAmount) {
		System.out.println("\n===== Electricity Bill =====");
		System.out.println("Consumer Number: " + consumerNumber);
		System.out.println("Consumer Name: " + consumerName);
		System.out.printf("Previous Meter Reading: %.2f%n", previousReading);
		System.out.printf("Current Meter Reading: %.2f%n", currentReading);
		System.out.printf("Units Consumed: %.2f%n", unitsConsumed);
		System.out.printf("Energy Charge: ₹%.2f%n", energyCharge);
		System.out.printf("Fixed Monthly Charge: ₹%.2f%n", fixedCharge);
		System.out.printf("Surcharge: ₹%.2f%n", surcharge);
		System.out.printf("Total Amount: ₹%.2f%n", totalAmount);
	}

	/**
	 * Reads a valid, non-negative decimal number from the scanner.
	 * InputMismatchException is caught and the input is prompted again.
	 */
	public static double readNonNegativeDouble(Scanner scanner, String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				double value = scanner.nextDouble();
				scanner.nextLine();

				if (!Double.isFinite(value)) {
					System.out.println("Error: Value must be a finite number. Please re-enter.");
				} else if (value < 0) {
					System.out.println("Error: Value cannot be negative. Please re-enter.");
				} else {
					return value;
				}
			} catch (InputMismatchException exception) {
				System.out.println("Error: Invalid number. Please enter a numeric value.");
				scanner.nextLine();
			} catch (NoSuchElementException exception) {
				throw new IllegalStateException("No numeric input is available.", exception);
			}
		}
	}
}
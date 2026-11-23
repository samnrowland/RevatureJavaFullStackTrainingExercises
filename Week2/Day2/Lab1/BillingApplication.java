package com.smartstore.billing;

import java.util.Scanner;

public class BillingApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Accept customer and product details
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();

		System.out.print("Enter product name: ");
		String productName = scanner.nextLine();

		System.out.print("Enter product price: ");
		double productPrice = scanner.nextDouble();

		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();

		// Calculate the purchase and discount amounts
		double totalAmount = productPrice * quantity;
		double discountAmount = calculateDiscount(totalAmount);

		printBill(customerName, productName, quantity, totalAmount, discountAmount);

		scanner.close();
	}

	// Calculates the discount amount based on the total purchase amount
	public static double calculateDiscount(double totalAmount) {
		double discountPercentage = calculateDiscountPercentage(totalAmount);
		return totalAmount * discountPercentage / 100;
	}

	// Determines which discount percentage applies
	private static double calculateDiscountPercentage(double totalAmount) {
		if (totalAmount >= 1000 && totalAmount < 5000) {
			return 5;
		} else if (totalAmount >= 5000) {
			return 10;
		}
		return 0;
	}

	// Prints the customer bill in the required format
	public static void printBill(String customerName, String productName, int quantity,
			double totalAmount, double discountAmount) {
		double discountPercentage = calculateDiscountPercentage(totalAmount);
		double finalAmount = totalAmount - discountAmount;

		System.out.println("\n========== CUSTOMER BILL - SMARTSTORE ==========");
		System.out.println("Customer Name    : " + customerName);
		System.out.println("Product          : " + productName);
		System.out.println("Quantity         : " + quantity);
		System.out.printf("Total            : Rs. %.2f%n", totalAmount);
		System.out.println("Discount         : " + (int) discountPercentage + "%");
		System.out.printf("Discount Amount  : Rs. %.2f%n", discountAmount);
		System.out.println("------------------------------------------------");
		System.out.printf("Final Amount     : Rs. %.2f%n", finalAmount);
		System.out.println("================================================");
	}
}
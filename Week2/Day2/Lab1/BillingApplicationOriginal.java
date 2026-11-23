package com.smartstore.billing;

import java.util.Scanner;

public class BillingApplicationOriginal {

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

		// Calculate the total purchase amount
		double totalAmount = productPrice * quantity;

		// Apply discount based on the total purchase amount
		double discountPercentage = 0; 
		if (totalAmount >= 1000 && totalAmount < 5000) {
			discountPercentage = 5; // If total is between Rs. 1000 and Rs. 5000, apply a 5% discount
		} else if (totalAmount >= 5000) {
			discountPercentage = 10; // If total is Rs. 5000 or higher, apply a 10% discount
		}

		double discountAmount = totalAmount * discountPercentage / 100;
		double finalAmount = totalAmount - discountAmount;

		// Display the billing details
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

		scanner.close();
	}
}
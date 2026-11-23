package com.smartstore.billing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalaryCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int employeeId = readEmployeeId(scanner);
		String employeeName = readEmployeeName(scanner);
		double basicSalary = readBasicSalary(scanner);

		// Calculate salary components using separate methods.
		double hra = calculateHra(basicSalary);
		double da = calculateDa(basicSalary);
		double grossSalary = calculateGrossSalary(basicSalary, hra, da);
		double professionalTax = calculateProfessionalTax(grossSalary);
		double netSalary = calculateNetSalary(grossSalary, professionalTax);

		displaySalaryDetails(employeeId, employeeName, basicSalary, hra, da,
				grossSalary, professionalTax, netSalary);

		scanner.close();
	}

	// Calculates House Rent Allowance as 20% of basic salary.
	private static double calculateHra(double basicSalary) {
		return basicSalary * 20 / 100;
	}

	// Calculates Dearness Allowance as 10% of basic salary.
	private static double calculateDa(double basicSalary) {
		return basicSalary * 10 / 100;
	}

	// Calculates total salary before tax deductions.
	private static double calculateGrossSalary(double basicSalary, double hra, double da) {
		return basicSalary + hra + da;
	}

	// Deducts Rs. 200 only when gross salary is above Rs. 20,000.
	private static double calculateProfessionalTax(double grossSalary) {
		if (grossSalary > 20000) {
			return 200;
		}
		return 0;
	}

	// Calculates salary after deducting professional tax.
	private static double calculateNetSalary(double grossSalary, double professionalTax) {
		return grossSalary - professionalTax;
	}

	// Keeps asking until the employee ID is a valid positive integer.
	private static int readEmployeeId(Scanner scanner) {
		int employeeId = 0;

		while (true) {
			System.out.print("Enter employee ID: ");
			try {
				employeeId = scanner.nextInt();
				if (employeeId > 0) {
					scanner.nextLine();
					return employeeId;
				}
				System.out.println("Invalid employee ID. Please enter a positive whole number.");
			} catch (InputMismatchException exception) {
				System.out.println("Invalid employee ID. Please enter a whole number.");
				scanner.nextLine();
			}
		}
	}

	// Keeps asking until the employee name is not empty.
	private static String readEmployeeName(Scanner scanner) {
		while (true) {
			System.out.print("Enter employee name: ");
			String employeeName = scanner.nextLine().trim();

			if (!employeeName.isEmpty()) {
				return employeeName;
			}
			System.out.println("Invalid employee name. Please enter a name.");
		}
	}

	// Keeps asking until the basic salary is a valid positive number.
	private static double readBasicSalary(Scanner scanner) {
		double basicSalary = 0;

		while (true) {
			System.out.print("Enter basic salary: Rs. ");
			try {
				basicSalary = scanner.nextDouble();
				if (basicSalary > 0) {
					scanner.nextLine();
					return basicSalary;
				}
				System.out.println("Invalid salary. Please enter an amount greater than zero.");
			} catch (InputMismatchException exception) {
				System.out.println("Invalid salary. Please enter a numeric amount.");
				scanner.nextLine();
			}
		}
	}

	// Displays all employee and salary information.
	private static void displaySalaryDetails(int employeeId, String employeeName,
			double basicSalary, double hra, double da, double grossSalary,
			double professionalTax, double netSalary) {

		System.out.println("\n========== EMPLOYEE SALARY DETAILS ==========");
		System.out.println("Employee ID       : " + employeeId);
		System.out.println("Employee Name     : " + employeeName);
		System.out.printf("Basic Salary      : Rs. %.2f%n", basicSalary);
		System.out.printf("HRA (20%%)         : Rs. %.2f%n", hra);
		System.out.printf("DA (10%%)          : Rs. %.2f%n", da);
		System.out.printf("Gross Salary      : Rs. %.2f%n", grossSalary);
		System.out.printf("Professional Tax  : Rs. %.2f%n", professionalTax);
		System.out.printf("Net Salary        : Rs. %.2f%n", netSalary);
		System.out.println("=============================================");
	}
}
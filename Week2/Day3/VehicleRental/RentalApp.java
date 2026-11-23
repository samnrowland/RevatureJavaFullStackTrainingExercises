package com.day3;

import java.util.ArrayList;
import java.util.Scanner;

public class RentalApp {

	public static void main(String[] args) {
		ArrayList<Vehicle> vArray = new ArrayList<Vehicle>();
		Scanner sc = new Scanner(System.in);
		System.out.print("How many vehicles are being rented?: ");
		int numVehicles = sc.nextInt();
		
		for (int i = 1; i <= numVehicles; i++) {
			Vehicle v;
			int type = 0;
			while (type < 1 || type > 2) {
				System.out.print("Enter type (1-Car, 2-Bike): ");
				type = sc.nextInt();
			}
			sc.nextLine();
			System.out.print("Enter vehicle number: ");
			String vehicleNum = sc.nextLine();
			System.out.print("Enter model: ");
			String model = sc.nextLine();
			System.out.print("Enter rate per day: ");
			double rate = sc.nextDouble();
			System.out.print("Enter number of days: ");
			int days = sc.nextInt();
			if (type == 1) {
				System.out.print("Enter insurance per day: ");
				double insurance = sc.nextDouble();
				sc.nextLine();
				// Vehicle v can be an instance of Car
				v = new Car(vehicleNum, model, rate, days, insurance);
			} else {
				// Vehicle v can be an instance of Bicycle
				v = new Bicycle(vehicleNum, model, rate, days);
			}
			vArray.add(v);
		}
		
		System.out.println("--- Rental Details ---");
		double totalRent = 0;
		for (Vehicle v : vArray) {
			v.displayDetails();
			totalRent += v.calculateRent();
		}
		System.out.println("Total rent collected: $" + totalRent);
		
		sc.close();
	}

}

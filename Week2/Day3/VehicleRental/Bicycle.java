package com.day3;

public class Bicycle extends Vehicle { // Bicycle inherits Vehicle 
	final double discount = 0.1;
	
	public Bicycle(String vehicleNumber, String model, double ratePerDay, int days) {
		// Vehicle constructor
		super(vehicleNumber, model, ratePerDay, days);
	}
	
	// Overriding of methods in Vehicle class
	@Override
	public double calculateRent() {
		return ratePerDay * days * (1 - discount);
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Bicycle | " + vehicleNumber + " | " + model + " | Rate per day: $" + ratePerDay + " | Days rented: " + days + " | Total charge: $" + calculateRent());
	}
}

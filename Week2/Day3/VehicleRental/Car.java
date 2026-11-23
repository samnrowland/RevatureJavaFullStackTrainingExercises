package com.day3;

public class Car extends Vehicle { // Car inherits Vehicle
	double insuranceCharge;
	
	
	
	public Car(String vehicleNumber, String model, double ratePerDay, int days, double insuranceCharge) {
		// Vehicle constructor
		super(vehicleNumber, model, ratePerDay, days);
		this.insuranceCharge = insuranceCharge;
	}

	// Overriding of methods in Vehicle class
	@Override
	public double calculateRent() {
		return (ratePerDay + insuranceCharge) * days;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("Car | " + vehicleNumber + " | " + model + " | Rate per day: $" + ratePerDay + " | Days rented: " + days + " | Total charge: $" + calculateRent());
	}
}

package com.coforge.day4.abstraction;

public class VehicleApp {

	public static void main(String[] args) {
		/*
		Bike bike = new Bike();
		bike.numberofEngine();
		bike.numberOfWheels();
		bike.brandName();
		
		System.out.println();
		
		Scooty scooty = new Scooty();
		scooty.numberofEngine();
		scooty.numberOfWheels();
		scooty.brandName();
		*/
		
		VehiclePlan vehicle; 
		
		vehicle = new Bike();
		vehicle.numberofEngine();
		vehicle.numberOfWheels();
		vehicle.brandName();
		
		vehicle = new Scooty();
		vehicle.numberofEngine();
		vehicle.numberOfWheels();
		vehicle.brandName();
	}

}

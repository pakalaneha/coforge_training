package com.coforge.day3;

public class Product {

	private int ProductID;
	private String ProductName;
	private int Price;
	private int Quantity;
	private int amount;

	public void displayBill() {
		System.out.println("Total Bill is " + amount);
	}

	public void calculateTotalAmount() {
		amount = Price * Quantity;
	}
}

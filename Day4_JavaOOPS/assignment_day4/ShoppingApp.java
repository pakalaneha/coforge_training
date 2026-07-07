package com.coforge.assignment;

public class ShoppingApp {

	public static void main(String[] args) {
		
		Customer customer = new Customer();
		
		customer.addProducts(new Product("milk", 30));
		customer.addProducts(new Product("chocolate",20));
		
		customer.addProducts(new Product("crayons",50));
		customer.removeProduct("chocolate");
		customer.removeProduct("chicken");
		System.out.println("The Bill is : "+customer.calculateBill());
		customer.showCart();
		
	}

}

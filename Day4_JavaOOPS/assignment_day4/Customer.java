package com.coforge.assignment;

public class Customer {
	Cart cart = new Cart();
	
	public void addProducts(Product product) {
		cart.addProducts(product);
	}
	
	public void removeProduct(String product) {
		cart.removeProduct(product);
	}
	
	public int calculateBill() {
		return cart.calculateBill();
	}
	
	public void showCart() {
		cart.showCart();
	}
}

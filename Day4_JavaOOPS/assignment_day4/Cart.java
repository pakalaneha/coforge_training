package com.coforge.assignment;
import java.util.ArrayList;
public class Cart {
	ArrayList <Product> list = new ArrayList<>();

	public void addProducts(Product product) {
		list.add(product);

		System.out.println(product.productName + " Added to cart");
	}	

	public void removeProduct(String product) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).productName.equals(product)) {
				list.remove(i);
		        System.out.println(product + " Removed");
		        return;

		    }

		}
		System.out.println(product+ " Not Found");

	}

	public int calculateBill() {
		int cost = 0;
		for (Product p:list) {
			cost+=p.productCost;
		}
		return cost;
	}
	
	public void showCart() {
		System.out.println("The items in the cart currently : ");

		for(Product p:list) {
			System.out.println(p.productName);
		}

	}
	
}

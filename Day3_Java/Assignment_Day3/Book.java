package com.coforge.day3;

public class Book {

	private int BookID;
	private String Title;
	private String Author;
	private int Price;

	public void display() {
		System.out.println("BookID is : " + BookID);
		System.out.println("Title is : " + Title);
		System.out.println("Author is : " + Author);
		System.out.println("Price is : " + Price);
	}
}

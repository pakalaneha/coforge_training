package com.coforge.day4.abstraction;

public class Rectangle extends Figure {
	// the program will give an error if there is no default constructor
	// so we have to explicitly call the constructor for it to work. 
	public Rectangle(){
		super(5,4); // calling it explicitly 
	}
	@Override 
	public void area() {
		System.out.println("Area of Rectangle : "+(getLength()*getBreadth()));
	}
	
	
	
}

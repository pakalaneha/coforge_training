package com.coforge.day4.abstraction;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		/*
		Rectangle rectangle = new Rectangle();
		rectangle.area();
		
		Square square = new Square();
		square.area();
		
		Triangle triangle = new Triangle();
		triangle.area();
		*/
		
		
		
		
		AreaPlan figure;  // only giving the reference for the interface i.e. abstraction 
		
		figure = new Rectangle();
		figure.area();
		figure = new Square();
		figure.area();
		figure = new Triangle();
		figure.area();
		
	}

}

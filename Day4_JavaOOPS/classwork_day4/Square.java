package com.coforge.day4;

public class Square extends Figure {
	public Square() {
		super(6);
	}
	@Override 
	public void area() {
		System.out.println("Area of Square : "+(getSide()*getSide()));
	}
}

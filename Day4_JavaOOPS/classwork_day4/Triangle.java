package com.coforge.day4;

public class Triangle extends Figure {
	public Triangle() {
		super(5L,4L);
	}
	@Override 
	public void area() {
		System.out.println("Area of Triangle : "+(0.5 * getBase()*getHeight()));
	}
}

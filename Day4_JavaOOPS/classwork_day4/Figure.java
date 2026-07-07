package com.coforge.day4;

public class Figure {
	private int length;
	private int breadth;
	private long height;
	private long base;
	private int side;
	
	public int getLength() {
		return length;
	}

	public int getBreadth() {
		return breadth;
	}

	public int getSide() {
		return side;
	}

	public long getBase() {
		return base;
	}

	public long getHeight() {
		return height;
	}

	
	
	
	// there is no default constructor 
	
	// initialising rectangle
	public Figure(int length, int breadth){
		this.length = length;
		this.breadth = breadth;
	}
	
	// initialising square
	public Figure(int side) {
		this.side = side;
	}
	
	// initialising triangle 
	public Figure(long base,long height) {
		this.base = base;
		this.height = height;
	}
	
	public void area() {
		System.out.println("Cannot define");
	}
	// if we use the 'final' keyword, then we cannot change anything about it
	// if we make the above method as 'final', then it cannot be overridden by the 
	// other classes, which has used the 'area' method. 
}

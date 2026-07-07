package com.coforge.day4.abstraction;

public abstract class Figure implements AreaPlan {
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
	
	// initialising rect
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
	
	// abstract method declaration 
	public abstract void area();
	
	
	 
	
}

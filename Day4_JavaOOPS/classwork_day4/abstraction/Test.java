package com.coforge.day4.abstraction;

public class Test implements C {

	public static void main(String[] args) {
		Test test = new Test();
		test.sum();

	}

	@Override
	public void sum() {
		// TODO Auto-generated method stub
		
		//	System.out.println(a+b);
		System.out.println(A.a + B.a); // calling it with help of interface / class name 
	}

}

package com.coforge.day6;

interface MyInterface {
	public default void myMethod1() {
		System.out.println("Default Method");
	}; // abstract optional

	public static void myMethod2() {
		System.out.println("Static Method");
	};

	public void myMethod3() {};
}

public class Java8InterfaceTest implements MyInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void myMethod3() {
		// TODO Auto-generated method stub
		System.out.println("Abstract Method");
	}

	// can override default
	@Override
	public void myMethod1() {
		System.out.println("Default Method");
	};
	// cannot override static methods
	// @Override
	// public void myMethod2() {
	// System.out.println("Static Method");
	// };

}

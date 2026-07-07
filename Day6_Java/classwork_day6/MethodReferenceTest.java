package com.coforge.day6;

@FunctionalInterface
interface MyReference {
	void showMessage();
}

public class MethodReferenceTest {
	
	void myInstanceMethod() {
		System.out.println("Example for Instance Method Reference");
	}
	
	static void myStaticMethod() {
		System.out.println("Example for Static Method Reference");
	}
	
	MethodReferenceTest() {
		System.out.println("Constructor");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// reference to a Instance Method
		MethodReferenceTest obj = new MethodReferenceTest();
		MyReference reference = obj::myInstanceMethod;
		reference.showMessage();
		
		//Reference to a Static Method
		reference = MethodReferenceTest::myStaticMethod;
		reference.showMessage();
		
		//Reference to a Constructor
		reference = MethodReferenceTest::new;
		reference.showMessage();
		
	}

}

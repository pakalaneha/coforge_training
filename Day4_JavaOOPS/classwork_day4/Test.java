package com.coforge.day4;

public class Test {

	public static void main(String[] args) {
		B b = new B();

	}

}

/* whenever we create a object of subclass, it is first executing 
superclass constructor and then the subclass constructor
this is called constructor chaining. 

when we add an parenthered constructor, the jvm first takes the 
constructor without a argument

constructor chaining - calling the constructor of the superclass
from the subclass with 'super' keyword

can constructor be inherited by the subclass- no. 
because if the subclass inherits the constructor, then the name 
constructor and the name of the class will be different.

private properties cannot be inherited. 

when a class becomes 'final', then it cannot have a subclass.  

if the constructor of the superclass is private, then it cannot 
be inherited. */


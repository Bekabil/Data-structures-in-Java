package com.stack.recursion.java;

/**
 * @author Bekabil Tolassa
 * Course:	ICS 340
 * Date:	March 7, 2015
 * Assignment: Recursion is Stack
 * Program description: This class TestRecursionAndStack class is written to test class Recursion_IS_Stack
 *						This class create an object count of type Recursion_IS_Stack.
 *						This class invokes methods countIterative() and countRecursive() on object count.
 *						This class prints out methods calls returned result along with some formatting to the console.
 */
public class TestRecursionAndStack {
    //main() method, the program starts running from here.
	public static void main(String[] args) {
		//an object count will be instantiated as type of Recursion_IS_Stack
		Recursion_IS_Stack count = new Recursion_IS_Stack();		
		//stars will be printed out for formatting
		System.out.println("*******************************************************************************");
		//this message and the return result of method countRecursive() call will be displayed.
		System.out.println("recursive list of values:\t" + count.countRecursive(4, 10));
		//stars will be printed out for formatting
		System.out.println("******************************************************************************");
		//stars will be printed out for formatting
		System.out.println("*******************************************************************************");
		//this message and the return result of method countIterative() call will be displayed.
		System.out.println("list of values popped off the stack:\t" + count.countIterative(4, 10));
		//stars will be printed out for formatting
		System.out.println("********************************************************************************");
		
	}

}


package com.stack.recursion.java;
//EmptyStackException exception is imported to use in case of empty stack attempt operation.
import java.util.EmptyStackException;
//Vector class is imported to use its functionalities
import java.util.Vector;
/**
 * @author Bekabil Tolassa
 * Course:	ICS 340
 * Date:	March 7, 2015
 * Assignment: Recursion is Stack
 * Program description: This class Recursion_IS_Stack class is written to find range of integer values and print them out.
 * 						This class uses three different, iteration, recursion, and stack implementation methods to accomplish its task.
 * 						This class uses methods countIterative(), countRecursive(), and countRecursively() will be used.
 * 						Stack object along with its methods, push(), pop(), peak(), isEmpty(), and size() also will be used.
 *						This class will be tested by class TestRecursionAndStack.
 */

public class Recursion_IS_Stack {
	//constructor Recursion_IS_Stack
	public Recursion_IS_Stack() {
		
	}
	/**
	 * Precondition: an object of this class must be created and instantiated. Two integer type argument must be passed.
	 * 				the first argument must be less than or equal to the second argument.
	 * Postcondition: sequence of numbers starting 'from' to 'to' inclusive are appended to strValue iteratively, 
	 * 					and the strValue is printed to the console. Integer elements are pushed into the Stack object, stackOfIntegers
	 * 					and the elements are popped off the stack and appended into stackStrValue, and StackStrValue will be returned.
	 * 					
	 * @param from
	 * @param to
	 * @return strValue
	 */
	public String countIterative(int from, int to) {
		//temp is local variable assigned with value of 'from'
		int temp = from;
		//pre and post are String variables to store integer values before and after increment.
		String pre= ""; String post= "";
		//stackOfIntegers is Stack type object
		Stack stackOfIntegers = new Stack();
		//local variable strValue is to store string form of numbers from - to
		String strValue = "";
		//local variable stackStrValue is to store string form of numbers off the stack stackOfIntegers.
		String stackStrValue = "";
		//execution of while loop will be repeated until 'from' becomes bigger than 'to'
		while(from <= to) {
			//pre is assigned to value of 'from' appended with "pre: " and new line
			pre += "pre: " + from + "\n";
			stackOfIntegers.push(from);
			System.out.println("Iterative pre:\t" + from);
			//append a digit of from with white space and appended to what was in the counter 
			strValue += from + " ";
			System.out.println("Iterative post:\t " + from);
			//from is preincremented by one.
			++from;
			
		}
		
		//execute the for loop statement as long as i (temp) is less than or equal to 'to'.
		for(int i = temp; i <= to; ++i) {
			//as long as the stack contains at least one element, execute the if statement block.
			if(!(stackOfIntegers.isEmpty())) {
				//post is assigned to the value of top of the stack appended with "pre: " and new line
				post += "post: " + stackOfIntegers.peak() + "\n";
				//stackStrValue is collection string form of an elements popped off the stack along with white space.
			    stackStrValue += stackOfIntegers.pop() + " ";
			}
			
		}//new line will be displayed
		System.out.println();
		//stars will be displayed for formatting
		System.out.println("********************************************************************************");
		//string format of integers that was collected iteratively will be displayed
		System.out.println("iterative list of values:\t" + strValue);
		//stars will be displayed for formatting
		System.out.println("********************************************************************************");
		//this message will be displayed
		System.out.println(" before elemens are pushed into the stack: ");
		//pre increment string format of integers that was collected will be displayed
		System.out.println(pre);
		//this message will be displayed
		System.out.println(" after elements are popped off the stack:");
		//post increment string format of integers that was collected will be displayed
		System.out.println(post);
		//stars will be displayed
		System.out.println("********************************************************************************");
		//string representation of elements off the stack will be returned to the caller
		return stackStrValue;
	}
	/**
	 * Precondition: an object of this class must be instantiated. Two integer type argument must be passed.
	 * 				the first argument must be less than or equal to the second argument.
	 * Postcondition: call result from method countRecursively() call is returned to the caller.
	 * @param from
	 * @param to 
	 * @return returning call result from method countRecursively() call
	 */
	public String countRecursive(int from, int to) {
		
		//return the result returned from method countRecursively()
		return countRecursively(from, to);
	}
	/**
	 * Precondition: an object of this class must be instantiated. Two integer type argument must be passed.
	 * 				the first argument must be less than or equal to the second argument.
	 * Postcondition: result of recursive call string representation of 'from' to 'to' along with white space is returned to the caller.
	 * @param from
	 * @param to 
	 * @return returning result of method countRecursively() call
	 */
	private String countRecursively(int from, int to) {
		//check if 'from' is less than or equal to 'to'
		if(from <= to)
		//print out this message along with 'from' to the console	
		System.out.println("Recursive post:\t " + from);
		//execution of while loop will be repeated until from becomes bigger than to
		while(from <= to) {
		//print out this message along with 'from' to the console		
		System.out.println("Recursive pre:\t" + from);	
		//string representation of 'from' along with white space is appended and returned to the caller.	
		//stopping case for this recursive call is when 'from' becomes greater than 'to'	
		return " " + from + countRecursively(from + 1, to);
		}
		//print new line
		System.out.println();
		//print the stars for formatting
		System.out.println("******************************************************************************");
		//return white space when 'from' becomes larger than 'to' 
		return " ";
	}
	
}


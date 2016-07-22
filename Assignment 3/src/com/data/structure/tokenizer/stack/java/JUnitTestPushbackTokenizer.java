package com.data.structure.tokenizer.stack.java;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author	Bekabil Tolassa
 * Date:	June 06, 2015
 * Class:	ICS 372
 * Program:	Assignment 3.
 * Purpose:	A JUnitTestPushbackTokenizer class is a test class written to test
 * 			the validity and functionality of methods in PushbackTokenizer class.
 * 			This class also tests if the value that passed to the 
 * 			 constructor is valid, and if stacks one and two are empty.			
 */

public class JUnitTestPushbackTokenizer {
/**
 * It creates an object test of type PushbackTokenizer
 * It tests hasMoreToken() method by calling assertTrue()
 *  method and passing actual result to see if it is true.
 * @param nothing.
 * @return nothing.
 */
	@Test
	public void testHasMoreToken() {
		PushbackTokenizer test = new PushbackTokenizer("Hello this is a test");
		boolean result = test.hasMoreTokens();
		assertTrue(result);
		
	}
/**
 * It creates an object test of type PushbackTokenizer
 * It tests nextToken() method by calling assertEquals()
 *  method and passing expected result and actual result.
 * @param nothing.
 * @return nothing.
 */	
	@Test
	public void testNextToken() {
		PushbackTokenizer test = new PushbackTokenizer("CIS370 CIS365 CIS141 CIS372 CIS311 CIS325");
		String result = "";
		for(int count = 1; count <= 4; count++)
			result = test.nextToken();
		assertEquals("CIS372", result);
		
	}
/**
 * It creates an object test of type PushbackTokenizer
 * It tests pushback() method by calling assertEquals()
 *  method and passing expected result and actual result.
 * @param nothing.
 * @return nothing.
 */
	@Test
	public void testPushBack() {
		PushbackTokenizer test = new PushbackTokenizer("Java is an Object Oriented Programming Language");
		String result = ""; 
		for(int count = 1; count <= 6; count++)
			result = test.nextToken();
			test.pushback();
		assertEquals("Programming", result);
		
	}
/**
 * It creates an object test of type PushbackTokenizer
 * It tests the constructor method by calling assertTrue()
 *  method and passing the return value of isDataValis() method.
 * @param nothing.
 * @return nothing.
 */	
	@Test
	public void testConstructor() {
		//String	result = "";
		PushbackTokenizer test = new PushbackTokenizer("Testing Constructor");
		assertTrue(test.isDataValid());

	}
/**
 * It creates an object test of type PushbackTokenizer
 * It tests if stack one is empty.
 * method asserTrue() is called by passing contains.
 * The assumption is stack one will be empty after 4 pushes
 *  in this case information message will be also triggered.
 *  @param nothing.
 *  @return nothing.	
 */
	@Test
	public void testIsStackOneEmpty() {
		String	result = "";
		PushbackTokenizer test = new PushbackTokenizer("Is Stack One Empty?");
		for(int count = 1; count <= 4; count++)
			test.pushback();
		boolean contains = test.isStackOneEmpty();
		assertTrue(contains);

	}
/**
 * It creates an object test of type PushbackTokenizer
 * It tests if stack two is empty.
 * method asserTrue() is called by passing contains.
 * The assumption is stack two will be empty after nextToken() is called 4 times
 *  @param nothing.
 *  @return nothing.	
 */
	@Test
	public void testIsStackTwoEmpty() {
		//String	result = "";
		PushbackTokenizer test = new PushbackTokenizer("Is Stack Two Empty?");
		for(int count = 1; count <= 4; count++) 
			test.nextToken();
		boolean contains = test.isStackTwoEmpty();
		assertTrue(contains);
	}
	
}
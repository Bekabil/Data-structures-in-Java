package com.data.structure.tokenizer.stack.java;
import java.util.*;

import javax.swing.JOptionPane;
/**
 * @author	Bekabil Tolassa
 * Date:	June 06, 2015
 * Class:	ICS 372
 * Program:	Assignment 3.
 * Purpose:	A PushbackTokenizer class implements PushbackableTokenizer interface.
 * 			This class is designed using the Adapter pattern.
 * 			Stack and StringTokenizer classes are adapted to accommodate 
 * 				complete functionality between the interface and the user. 
 * 			The implementation of all methods in the interface is done in this class.
 * 			By doing so, this Object Adapter pattern design allows incompatible 
 * 		     classes to work together by converting the interface PushbackableTokenizer
 * 			 into an interface expected by the clients.
 * 			This class allows the user to read a token and push it back to the stream
 * 			 from which the token was read. 
 * 			Tokens are assumed to be separated by white space.
 * 			Any number of tokens may be pushed back.
 * 			Validity and functionality of methods and constructor of this class
 * 			 will be tested using assert statements in JUnitTestPushbackTokenizer class.			
 */
public class PushbackTokenizer implements PushbackableTokenizer {
/*
	* String type data is stored in the data data field.
	* StringTokenizer type object is stored in the token data field
	* String type tokens are stored in Stack tokensOfStackOne and tokensOfStackTwo
*/	
	private String data;
	private  StringTokenizer token; 
	
	private Stack<String> tokensOfStackOne = new Stack<String>();
	private Stack<String> tokensOfStackTwo = new Stack<String>();
/**
* creates new StringTokenizer type token.
* initializes data field with new data
* it separates tokens and stores them in tokensOfStackOne
* it stores each tokens of tokensOfStackOne in tokensOfStackTwo 
* @param String type data that tokens will be created from.
	
*/
	public PushbackTokenizer(String newData) {
		this.data = newData;
		token = new StringTokenizer(newData);

		while(token.hasMoreTokens()){
	         tokensOfStackOne.push(token.nextToken());
	     }
		while (!tokensOfStackOne.isEmpty()) {
			 tokensOfStackTwo.push(tokensOfStackOne.pop());
		 }
		
	}

/**
 * overrides method nextToken()
 * it removes token off stack two and stores in stack one 
 * it displays information message if stack one is empty.	
 * @param nothing.
 * @return the next token off top of stack one
*/	
	@Override
	public String nextToken() {
		
		if(hasMoreTokens()) {
			tokensOfStackOne.push(tokensOfStackTwo.pop());
			return tokensOfStackOne.peek();
		}
		//there are no more tokens, so display information message
		else
			JOptionPane.showMessageDialog(null, 
				"Ther is no more next token to display!", 
				"Next Token", JOptionPane.INFORMATION_MESSAGE);
		return "";
	}
/**
 * overrides method hasMoreToken()
 * Returns true if and only if there are more tokens
 * @param nothing.
 * @return true if there is at least one more token in stack two; else false 
 */
	@Override
	public boolean hasMoreTokens() {
		return (!tokensOfStackTwo.isEmpty());
	}
/**
 * overrides method pushback()
 * If stack one is not empty, the last token read and is not pushed back
 * is pushed back to stack two, so it can be read again using nextToken.
 * It displays information message if stack one is empty.
 * @param nothing.
 * @return nothing. 
 */
	@Override
	public void pushback() {
		if(!tokensOfStackOne.isEmpty())
			tokensOfStackTwo.push(tokensOfStackOne.pop());
		else //since stack one is empty, nothing to push back
			JOptionPane.showMessageDialog(null, 
					"There is no more token to be pushed back!", 
					"Push Back", JOptionPane.INFORMATION_MESSAGE);
	}
/**
* It checks if Stack one is empty or not.
* @param nothing.
* @returns true if stack one is not empty, else false.
*/	
	public boolean isStackOneEmpty() {
		return (tokensOfStackOne.isEmpty());
	}
/**
* It checks if Stack two is empty or not.
* @param nothing.
* @returns true if stack two is not empty, else false.
*/	
	public boolean isStackTwoEmpty() {
		return (tokensOfStackTwo.isEmpty());
	}
/**
* It checks if current data is an instance of String.
* @param nothing.
* @returns true if data is a type of String.
*/	
	public boolean isDataValid() {
		return (this.data instanceof String);
	}
/**
* It makes both stacks empty.
* @param nothing.
* @returns nothing.
*/	
	public void clearStackOftokens() {
		this.tokensOfStackOne.clear();
		this.tokensOfStackTwo.clear();
	}	 

}

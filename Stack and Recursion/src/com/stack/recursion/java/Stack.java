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
 * Program description: This class Stack extends Vector class. This class is written to be used
 * 						by class Recursion_IS_Stack. When an an object of Stack is created, all of
 * 						its public methods will be available for use.
 * 						The Stack class uses its methods push(), pop(), peak() to push element into the stack,
 * 							to pop off an element off the top of the stack, and to view or look at the top element.
 * 						The Stack class also uses its methods isEmpty() and size() to check if the stack is empty, and
 * 						 to get the size of the stack.
 *
 */
class Stack extends Vector {
		//constructor Stack
		public Stack() {
			
		}
		/**
		 * Precondition: an object of type Stack must be created. The stack may contain some elements.
		 * Postcondition: size() method is called to check size of the stack.
		 * 				  true value is returned is the stack contains at least one element.
		 * 				  Otherwise, false value is returned.	
		 * @param none
		 * @return boolean value
		 */
		public boolean isEmpty() {
			return size() == 0;
	  }
		/**
		 * Precondition: an object of type Stack must be created. The stack may contain elements.
		 * Postcondition: method peak() is called, if the stack is not empty, 
		 * 					an element data is popped off the top of the stack. 
		 * 					an element data is returned. the stack is one element less than its previous size.
		 * @param none
		 * @return integer type data
		 */
		public int pop() {
			//method peak() is called, returned value will be assigned to variable data.
			int data = peak();
			//top of the stack is at position stack size minus one.
			//integer element on top of the stack is removed.
			removeElementAt(size() - 1);
			//integer element data is returned
			return data;
		}
		/**
		 * Precondition: an object of type Stack must be created. The stack may contain elements.
		 * 				If the stack is empty this method throws exception.
		 * Postcondition: an element data that is on top of the stack is viewed and returned.
		 * 					The size of the stack is unchanged.
		 * @param none
		 * @return integer type element
		 */
		public int peak() {
			//method isEmpty() is called to check if the stack is empty.
			//tying to peak() off empty stack may cause an EmptyStackException to be thrown.
			if(isEmpty())throw new EmptyStackException();
			//top of the stack is at position stack size minus one.
			//integer element off the top of the stack is returned
			return (int) elementAt(size() - 1);
		}
		/**
		 * Precondition: an object of type Stack must be created. integer type data must be passed.
		 * Postcondition: an element data is pushed into on top of the stack.
		 * 					The stack size is one element more than its previous size.
		 * @param data
		 * @return void
		 */
		public void push(int data){
			//an element data is added onto the top of the stack
			addElement(data);
		}
	}


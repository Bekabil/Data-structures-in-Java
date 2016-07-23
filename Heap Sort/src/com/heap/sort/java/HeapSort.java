package com.heap.sort.java;
//import java.util.Arrays to use methods such as toString() of Arrays class
import java.util.Arrays;
/**
 * @author Bekabil Tolassa
 * Course:	ICS 340
 * Date:	March 10, 2015
 * Assignment: Heap Sort
 * Program description: class HeapSort is generic type and it will be tested by class TestHeapSort.
 * 						This class creates String array of some random data and assign them into theHeap array.
 *						This class extends Comparable Class in order to compare two strings using method compareTo().
 *						This class uses theHeap array of type HeapNode to store the string data elements.
 *						This class sorts the data elements and prints them out in alphabetical order.
 *						This class prints out a tree form of data elements, and every steps of sorting the elements.
 *						This class uses several methods such as insert(), pop(), heapSort(), arrayHeap(), and more
 *							to accomplish its task. This class also uses HeapNode to create arrayHeap.
 */
public class HeapSort < KEY extends Comparable < String > > {
    //theHeap is array of type HeapNode
    HeapNode < KEY > [] theHeap;
    //arrayElements is initially 0. It keeps counting number of items in the array
    int arrayElements = 0;
    //maxSize is the size of array
    int maxSize;
    //constructor HeapSort with one parameter
    public HeapSort(int maxSize) {
            //maxSize of this object is set to maxSize
            this.maxSize = maxSize;
            //theHeap array is created and the size is set to maxSize
            theHeap = new HeapNode[maxSize];

        }
        /**
         * Precondition: theHeap array must be created.
         * 				when this method is called, integer type index and HeapNode type newData must be passed.
         * Postcondition: The new data is stored in theHeap array at location index.
         * @param index
         * @param newData
         * @return void
         */
    public void insert(int index, HeapNode < KEY > newData) {
            //the array at location index assigned with new value.
            theHeap[index] = newData;

        }
        /**
         * Precondition: An array of this object must be created.
         * Postcondition: arrayElements is incremented by one. Number of elements in the array is
         * 				one more than what it was.
         * @param none
         * @return none
         */
    public void increaseArrayElements() {
            //arrayElements is incremented by one
            arrayElements++;

        }
        /**
         * Precondition: The array of this object must be created. Data element(s) must be stored in the array.
         * Postcondition: The maximum value element is removed and returned. The data elements in the array is one less than its previous content.
         * @param none
         * @return HeapNode type, max
         */
    public HeapNode < KEY > pop() {

            //toString() method is invoked on Arrays object, theHeap array is passed. 
            //toString() method of Arrays class in invoked to represent string form of, and theHeap will be printed out
            System.out.println(Arrays.toString(theHeap) + "\n");
            //max is HeapNode type and assigned with the value of theHeap at index 0.
            HeapNode < KEY > max = theHeap[0];
            //theHeap array of index 0 is assigned with the item at theHeap array with index of one less than arrayElements	
            theHeap[0] = theHeap[--arrayElements];
            //method arrayHeap() is called and value 0 is passed. 
            arrayHeap(0);
            //maximum value (item) in the array is returned.
            return max;
        }
        /**
         * Precondition: Array of this object must be created and filled with data elements. Integer type numOfRow must be passed.
         * Postcondition: Data elements in theHeap array is printed in binary tree form, formating and intention is applied.
         * @return none
         * @param numOfRow
         */
    public void printFormOfTree(int numOfRow) {

            // distance is number of spaces between items in tree format
            int distance = 0;
            //numOfLoop is number of iteration
            int numOfLoop = 1;

            // indent is array of integer, it generate all of the indents that are
            // needed depending on the number of rows to print
            //indent is assigned with a value of getIndentArray() method call. numOfRow is passed.
            int[] indent = getIndentArray(numOfRow);
            //while loop will be repeating as long as numOfLoop is less than or equal to numOfRow.
            while (numOfLoop <= numOfRow) {

                // Find the first Index : .5 * (-1 + 2^n)
                int indexToPrint = (int)(.5 * (-1 + (Math.pow(2, numOfLoop))));

                // Find number of Items per Row : 2^(n - 1)
                //itemsPerRow is integer type and it is assigned with
                //Integer value of returned from pow() method of Math class.
                int itemsPerRow = (int)(Math.pow(2, numOfLoop - 1));
                //maxIndexToPrint integer type holding the sum of indexToPrint and itemsPerRow
                int maxIndexToPrint = indexToPrint + itemsPerRow;

                // using for loop print the indents needed
                for (int j = 0; j < indent[numOfLoop - 1]; j++)
                    System.out.print(" "); //print white space

                // using for loop print all of the index values for each row
                // indexToPrint represents the first index in the
                // row, while maxIndexToPrint equals the last
                for (int index = indexToPrint; index < maxIndexToPrint; index++) {
                    // If the array isn't full don't try to print
                    // indexes that don't exist
                    if (index < arrayElements) {
                        //string formated data element of the heap array will be printed
                        System.out.print(String.format("%s", theHeap[index].getData()));
                        //as long as k is less than distance repeat
                        for (int k = 0; k < distance; k++)
                            System.out.print(" "); //print white space

                    }

                }

                // In a tree the spaces get bigger in the
                // same way that indents get smaller
                distance = indent[numOfLoop - 1];
                //numOfLoop is incremented
                numOfLoop++;
                //print new line
                System.out.println();

            }

        }
        /**
         * Precondition: integer type number of rows must be passed
         * Postcondition: array indentArray is sorted and returned.
         * @param rows
         * @return integer type array indentArray
         */

    public int[] getIndentArray(int numRows) {
            //indentArray is integer type array of size rows
            int[] indentArray = new int[numRows];
            //for loop is repeating as long as i is less than mumber of rows
            for (int i = 0; i < numRows; i++) {
                //abs() and pow() methods of Math class are used to fill the array with integer value.        	
                indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));

            }
            //sort() method of Arrays class is invoked to sort indentArray.
            Arrays.sort(indentArray);
            //indentArray is assigned with the reversed value of method call reverseArray(), indentArray is passed
            indentArray = reverseArray(indentArray);
            //reversed indentArray is returned
            return indentArray;
        }
        /**
         * Precondition: integer type array theArray must be passed
         * Postcondition: the array theArray is reversed from biggest to smallest and returned
         * @param integer array theArray
         * @return theArray
         */
    public int[] reverseArray(int[] theArray) {

        // leftIndex is index of the first element
        int leftIndex = 0;

        // rightIndex is index of last element
        int rightIndex = theArray.length - 1;
        //while loop is repeating as long as leftindex is less than rightIndex
        while (leftIndex < rightIndex) {
            //temp is integer type and assigned with arary element at leftIndex
            int temp = theArray[leftIndex];
            //Exchange the left and right elements
            theArray[leftIndex] = theArray[rightIndex];
            //temp is stored in an array at rightInde
            theArray[rightIndex] = temp;

            // Move the indexes to check towards the middle
            //increment leftIndex
            leftIndex++;
            //decrement righIndex
            rightIndex--;
        }
        //return theArray
        return theArray;
    }

    /**
     * Precondition: object of this class must exist.
     * Postcondition:the heap is filled up with string type random data elements
     * @param none
     * @return void
     */
    public void generateFilledArray() {
            //strData is String type array and initialized with 13 string values.
            String[] strData = {
                "Success", "Work", "King", "Queen",
                "Zibra", "Armor", "Olive", "June",
                "Yellow", "Peace", "Access", "July", "Summer"
            };

            //data is a type HeapNode.
            HeapNode data;
            //for loop is repeating as long as i is less than the size of this object
            for (int i = 0; i < this.maxSize; i++) {
                //data is a new node created holding the element 'i' of strData	        	
                data = new HeapNode < KEY > (strData[i]);
                //insert() method is invoked and arguments 'i' and 'data' are passed 
                this.insert(i, data);

                //increaseArrayElements() method is called to increment array element
                increaseArrayElements();
            }

        }
        /**
         * Precondition: the array heap must exist containing some data elements. integer type index must be passed.
         * Postcondition: data elements within array is compared and rearranged based according to the properties of the heap
         * @return void
         * @param index
         */
    public void arrayHeap(int index) {
        //largestChild is integer type local variable
        int largestChild;
        //root is HeapNode type and it holds the value of theHeap at index location.
        HeapNode < KEY > root = theHeap[index];
        //while loop is repeating as long as the result of arrayElements divide by 2 is bigger than index
        while (index < arrayElements / 2) {

            // assign the index for the leftChild to the leftChild variable
            int leftChild = 2 * index + 1;

            // assign the index for the rightChild to the rightChild variable
            int rightChild = leftChild + 1;

            // if statment is to check if leftChild is less than rightChild
            // if so, save rightChild in largestChild variable
            if (rightChild < arrayElements &&
                theHeap[leftChild].getData().compareTo(theHeap[rightChild].getData()) < 0) {
                //largestChild gets value of rightChild	
                largestChild = rightChild;

            } else {

                // Otherwise leftChild gets the largestChild
                largestChild = leftChild;

            }

            // check and see if the root is greater then the largestChild
            // if so, break out of the while loop
            if (root.getData().compareTo(theHeap[largestChild].getData()) >= 0)
                break;

            // save the value in largest child into the top index
            theHeap[index] = theHeap[largestChild];
            //index is set to the largestChild.
            index = largestChild;
            //print new line
            System.out.println();
            //call method printFormOfTree() and pass 5 as an argument
            printFormOfTree(5);
            //print new line
            System.out.println();

        }
        //theHeap array at index is set to the root.
        theHeap[index] = root;

    }

    /**
     * Precondition: the heap array with data elements must exist.
     * Postcondition: the heap elements are popped off and sorted from the smallest to the largest
     * @param none
     * @return none
     */
    public void heapSort() {
        //for loop repeat execution downward from maxSize - 1 to 0
        for (int k = maxSize - 1; k >= 0; k--) {
            //method pop() is called, the return value is assigned to largestNode
            HeapNode < KEY > largestNode = pop();
            //method insert() is called, parameter k and largestNode are passed.
            insert(k, largestNode);

        }

    }


}
package com.heap.sort.java;
//import java.util.Arrays to use methods such as toString() of Arrays class
import java.util.Arrays;
/**
 * @author Bekabil Tolassa
 * Course:	ICS 340
 * Date:	March 10, 2015
 * Assignment: Heap Sort
 * Program description: class TestHeapSort is is written to test the class HeapSort.
 * 						This class creates an object newHeap type of the HeapSort.
 * 						This class invokes methods arrayHeap(), heapSort(), generateFilledArray(), 
 *                        printFormOfTree(), and more on newHeap object in order to complete the heap process,
 *                        sorting the array, and print out the process and the tree form of the heap.
 *
 */

public class TestHeapSort {
    //main() method, the program starts execution from here.
    public static void main(String args[]) {
        //newHeap is type HeapSort to contain 13 data elements of Strings. 
        HeapSort <String> newHeap = new HeapSort(13);
        //method generateFilledArray() is invoked on object newHeap to fill theHeap with data elements
        newHeap.generateFilledArray();

        // Print out the array before it is sorted
        System.out.println("*********************************************************************************************************");
        //print stars and text mesage for formatting
        System.out.println("******************************* Initial content of Array ************************************************\n");
        // Print out the array before it is sorted after toString() method of Arrays class is invoked
        System.out.println(Arrays.toString(newHeap.theHeap));
        //stars and text messages are printed
        System.out.println("\n********* The Heap process is in progress... \n\n");
        //printFormOfTree() method is called for formatting, 5 is passed as an argument
        newHeap.printFormOfTree(5);
        //print new line
        System.out.println();
        //for loop repeats calling arrayHeap() method as long as index is greater than or equal to 0.
        for (int index = newHeap.maxSize / 2 - 1; index >= 0; index--) {
            //method arrayHeap() is invoked on object newHeap, index is passed as an argument
            newHeap.arrayHeap(index);
        }
        //print stars for formatting.
        System.out.println("*********************************************************************************************************");
        //print stars and text message for formatting.
        System.out.println("************************* After the heap process is completed *******************************************\n");
        //theHeap array content are printed out after toString() method of Arrays class is invoked.
        System.out.println(Arrays.toString(newHeap.theHeap) + "\n");
        //printFormOfTree() method is called for formattin, 5 is passed as an argument
        newHeap.printFormOfTree(5);
        //print stars for formatting.
        System.out.println("********************************************************************************************************");
        //print stars and text message for formatting.
        System.out.println("************ Sorting contents of the heap array is in progress...\n");
        //heapSort() method is invoked on newHeap object
        newHeap.heapSort();

        //print stars for formatting.
        System.out.println("*********************************************************************************************************");
        //print stars and text message for formatting.
        System.out.println("******************************** Completley sorted array ************************************************\n");
        //sorted theHeap array content are printed out after toString() method of Arrays class is invoked. 
        System.out.println(Arrays.toString(newHeap.theHeap));

    }

}
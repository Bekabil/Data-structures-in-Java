package com.heap.sort.java;
/**
 * @author Bekabil Tolassa
 * Course:	ICS 340
 * Date:	March 10, 2015
 * Assignment: Heap Sort
 * Program description: class HeapNode is generic type and it is written to be used by class HeapSort.
 *						This class uses getter method getData() to return the data of this object.
 *						This class also uses toString() method to represent and return string form of data of this object.
 */
public class HeapNode < KEY > {
    //data is private to this class
    private String data;
    //constructor HeapNode with one argument
    HeapNode(String strData) {
            //private data field is assigned to strData
            this.data = strData;

        }
        /**
         * Precondition: An object of HeapNode must be created. At least one data item must exist.
         * Postcondition: data of this object is returned.
         * @param none    
         * @return data
         */
    public String getData() {
            return data;
        }
        /**
         * Precondition: An object of HeapNode must be created. At least one data item must exist.
         * Postcondition: string form of data of this object is returned.
         * @param none    
         * @return string representation of data
         */
    public String toString() {

        return data + " ";

    }

}
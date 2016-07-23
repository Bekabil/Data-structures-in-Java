package com.avl.tree.java;
/**
 * @author		Bekabil Tolassa
 * Course:		ICS 340
 * Date:		March 12, 2015
 * Assignment:	Balancing Binary Tree (AVL Tree)
 * Program description: This class AVLNode is a generic class that is written to be used by a class AVLTree.
 * 						Objects of this class AVLNode is expected to be constructed to form an AVLTree within an AVLTree class.
 * 						methods getData() and setData() will be used to get data of this object and to reset data field with new data.	
 */
public class AVLNode < KEY > {
    //height is a height of a node
    int height;
    //private data field data
    private KEY data;
    //left child of a node
    AVLNode < KEY > left;
    //right child of a node
    AVLNode < KEY > right;

    //constructor AVLNode with one argument
    public AVLNode(KEY thisData) {
            //this object is initialized with data to be thisData, both children to be null.
            this(thisData, null, null);
    }
        //constructor with with three arguments
    public AVLNode(KEY newData, AVLNode < KEY > leftChild, AVLNode < KEY > rightChild) {
            //this data is assigned with newData
            this.data = newData;
            //this left child is assigned with leftChild
            this.left = leftChild;
            //this right child is assigned with rightChild
            this.right = rightChild;
            //this height is set to 0
            this.height = 0;
    }
        /**
         * Precondition: an object of this class must be created.
         * Postcondition: data of this object is returned.
         * @param none
         * @return data
         */
    public KEY getData() {
            //data is returned
            return data;
        }
        /**
         * Precondition: an object of this class must be created.
         * Postcondition: data field of this object is set to newData
         * @return none
         * @param newData
         */
    public void setData(KEY newData) {
        //this data is assigned with newData
        this.data = newData;
    }

}
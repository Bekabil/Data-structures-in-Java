package com.avl.tree.java;
/**
 * @author		Bekabil Tolassa
 * Course:		ICS 340
 * Date:		March 12, 2015
 * Assignment:	Balancing Binary Tree (AVL Tree)
 * Program description: This class TestAVLTree is written to test a class AVLTree.
 * 						This class creates an object of an AVLTree called tree to store integer data type.
 * 						This class also creates integer type array called arrayInt to store data elements.
 * 						This class uses a random() method of Math class to generate some random numbers and add them in the tree.
 * 						This class uses several methods of an AVLTree class to insert, remove, search, and count the elements.
 * 						For example, methods such as add(), remove(), search(), getNumOfNodes(), getMax(), and getMin()
 * 							will be used to accomplish the testing process of the AVLTree class.
 * 						This class uses three different methods to traverse an AVL Tree.
 * 						inorderTraverseTree(), preorderTraverseTree(), and postorderTraverseTree() will be used to display elements of an AVL Tree.	
 */
public class TestAVLTree {

    //main() method, the program execution starts from here.
    //This method may throw a new Exception in case of attempting to access an empty tree.
    public static void main(String[] args) throws Exception, ArrayIndexOutOfBoundsException { // the tree is type AVLTree that contains integers
        AVLTree < Integer > tree = new AVLTree < > ();
        //counter is a local variable to count items that will be added to the tree
        int counter = 0;
        //dataElement is holding the element that will be generated randomly 
        int dataElement = 0;
        //arrayInt is an array of integer of size 1000
        int[] arrayInt = new int[1000];
        //new line will be printed
        System.out.println();
        //stars will be displayed
        System.out.println("*********************************************************************************************************************************************************************************************************");
        //stars and text message will be displayed
        System.out.println("*** Tesiting an AVL tree by inserting and deleting randomly Generated numbers ****************************************************************************************************************************************************");
        do { //random() method of Math class is generating random numbers
            //integer part of generated number is multiplied by 127 and stored in dataElement
            dataElement = (int)(Math.random() * 127);
            //dataElement is added to the AVL tree
            tree.add(dataElement);
            //dataElement is also stored in arrayInt of index counter.
            arrayInt[counter] = dataElement;
            ++counter; //increment counter.
            //break out of this loop when dataElement becomes equal to 13
        } while (dataElement != 13);
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //stars and text message will be displayed
        System.out.println("********************** Inorder traversal of an AVL Tree *********************************************************************************************************************************");
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //inorderTraverseTree() method will be invoked on the tree object
        tree.inorderTraverseTree(tree.getRoot());
        //new line will be displayed
        System.out.println("\n");
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //stars and text message will be displayed
        System.out.println("********************** Preorder traversal of an AVL Tree *********************************************************************************************************************************");
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //preorderTraverseTree() method will be invoked on the tree object
        tree.preorderTraverseTree(tree.getRoot());
        //double new line will be displayed
        System.out.println("\n");
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //stars and text message will be displayed
        System.out.println("********************** Postorder traversal of an AVL Tree *******************************************************************************************************************************");
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //postorderTraverseTree() method will be invoked on the tree object
        tree.postorderTraverseTree(tree.getRoot());
        //new line will be displayed
        System.out.println();
        //stars will be displayed
        System.out.println("****************************************************************************************************************************************************************************************");
        //getNumOfNodes() method will be invoked on the tree object, returned value will be displayed
        System.out.println("\nnumber of elements in the tree: " + tree.getNumOfNodes());
        //display new line
        System.out.println();
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //method getMax() will be invoked on object tree to get the maximum value, the returned number will be displayed.
        System.out.println("Maximum number in the AVL tree is: " + tree.getMax());
        //method getMin() will be invoked on object tree to get the minimum value, the returned number will be displayed.
        System.out.println("Minimum number in the AVL tree is: " + tree.getMin());
        //stars will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //new line will be displayed
        System.out.println();
        //search() method will be invoked on the tree object, number 13 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 13 contained in the tree?\t" + tree.search(13));
        //search() method will be invoked on the tree object, number 49 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 49 contained in the tree?\t" + tree.search(49));
        //search() method will be invoked on the tree object, number 111 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 111 contained in the tree?\t" + tree.search(111));
        //search() method will be invoked on the tree object, number 21 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 21 contained in the tree?\t" + tree.search(21));
        //search() method will be invoked on the tree object, number 125 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 125 contained in the tree?\t" + tree.search(125));
        //search() method will be invoked on the tree object, number 7 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 7 contained in the tree?\t" + tree.search(7));
        //new line will be displayed
        System.out.println();
        //stars and will be displayed
        System.out.println("***************************************************************************************************************************************************************************************");
        //stars and text message will be displayed
        System.out.println("************** postorder traversal after random elements are removed off the AVL tree **************************************************************************************************");
        //stars will be displayed   	
        System.out.println("****************************************************************************************************************************************************************************************");

        do { //remove elements off the AVL tree randomly and repeatedly 
            //do while {} statement invokes the remove method on the tree object to remove element
            //identical elements in the arrayInt of index ++counter will be deleted off the tree.
            tree.remove(arrayInt[++counter]);
            //counter is assigned to counter - 3
            counter = counter - 3;
            // end the loop when counter becomes less than 0
        } while (counter >= 0);

        //invoke postorder traversal on object tree after deletion of some elements. The root of the tree is passed
        tree.postorderTraverseTree(tree.getRoot());
        //make a new line
        System.out.println();
        //printing stars for output decoration
        System.out.println("******************************************************************************************************************************************************************************************* ");
        //make a new line
        System.out.println();
        //method getMax() will be invoked on object tree to get the maximum value, the returned number will be displayed.
        System.out.println("Maximum value in the tree after some items are deleted: " + tree.getMax());
        //method getMin() will be invoked on object tree to get the minimum value, the returned number will be displayed.
        System.out.println("Minimum value in the tree after some items are deleted: " + tree.getMin());
        //stars will be displayed
        System.out.println("***************************************************************************");
        //search() method will be invoked on the tree object, number 13 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 13 contained in the tree?\t" + tree.search(13));
        //search() method will be invoked on the tree object, number 49 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 49 contained in the tree?\t" + tree.search(49));
        //search() method will be invoked on the tree object, number 111 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 111 contained in the tree?\t" + tree.search(111));
        //search() method will be invoked on the tree object, number 21 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 21 contained in the tree?\t" + tree.search(21));
        //search() method will be invoked on the tree object, number 125 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 125 contained in the tree?\t" + tree.search(125));
        //search() method will be invoked on the tree object, number 7 will be searched, boolean type returned value will be displayed.
        System.out.println("Is number 7 contained in the tree?\t" + tree.search(7));
        //stars will be displayed 
        System.out.println("***************************************************************************");
        //make a new line
        System.out.println();
        //getNumOfNodes() method will be invoked on the tree object, returned value will be displayed
        System.out.println("number of elements in the tree after some items are deleted: " + tree.getNumOfNodes());
        //make a new line
        System.out.println();
        //getNumOfNodes() method will be invoked on the tree object, returned value will be displayed
        System.out.println("Removing the entire tree... ");
        tree.removeAVlTree();
        System.out.println("number of elements in the tree after the tree is removed: " + tree.getNumOfNodes());
        System.out.println();
        //end of test message will be displayed
        System.out.println("********************** End of the test ********************\n");

    }

}
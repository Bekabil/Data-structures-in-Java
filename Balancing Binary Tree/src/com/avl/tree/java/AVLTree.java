package com.avl.tree.java;
/**
 * @author		Bekabil Tolassa
 * Course:		ICS 340
 * Date:		March 12, 2015
 * Assignment:	Balancing Binary Tree (AVL Tree)
 * Program description: This class AVLTree is written to make an AVL tree by satisfying the properties of an AVL Tree.
 * 						This class is generic class and it creates an object 'root' type of an AVLNode. 
 * 						This class implements several private and public methods such as add(), remove(), search(), checkBalance(), balance(),
 * 									getNumOfNodes(), getMax(), and getMin(), to accomplish the task of keeping an AVLTree balanced.
 * 						This class uses three different methods to traverse the AVL Tree. inorderTraverseTree(), preorderTraverseTree(), 
 * 						and postorderTraverseTree() methods will be used to traverse an display elements of an AVL Tree.
 * 						This class may throw new Exception in case of attempting to access empty tree.
 * 						The object root of this class is private and hidden outside of this class. 
 * 							The root of this tree is only accessible through getter method, getRoot() 
 * 						This class extends Comparable class and it uses compareTo method() to compare two data elements. 
 *@param <KEY>
 */
public class AVLTree < KEY extends Comparable < KEY > > {
    //root is type AVLNode
    private AVLNode < KEY > root;
    //ONE is constant private data field
    //ONE is the maximum allowable height of subtree.
    private final int ONE = 1;
    //Constructor AVLTree with no arguments.
    public AVLTree() {
            //assign null value to the root
            root = null;
        }
        /**
         * Precondition: The object of this class must be created and instantiated.
         * Postcondition: The root of this tree is returned.
         * @param none
         * @return the root
         */
    public AVLNode < KEY > getRoot() {
            //return the root node
            return root;
        }
        /**
         * Public method add()
         * Precondition: an object of this class must be created and instantiated. One argument data must be passed.
         * 				private method add() with two arguments must be exist.
         * Postcondition: private method add() is called, data element and the root node are passed as an argument.
         * 					returned node will be assigned to the root.
         * @return void.
         * @param data the item to insert.
         */
    public void add(KEY data) {
        root = add(data, root);
    }

    /**
     * Precondition: An object of this class must be created and instantiated. 
     * 				Parameters data and root must be passed.
     * Postcondition:data element is compared with root's children data element by calling add() method recursively.
     * 				 data element is added to the AVL tree either to the left or to the right of the root.	
     * 				 Duplicate data element is ignored. method balance() is called to balance the tree.	
     * @param data an element to be added to the tree
     * @param root the node that is parent of subtree
     * @return an AVLNode type node that will be returned from balance() method call.
     */
    private AVLNode < KEY > add(KEY data, AVLNode < KEY > root) { //check and see if root is null
        if (root == null) //if so, create new node with data elements and null children, and return this new node.
            return new AVLNode < > (data, null, null);
        //invoke compareTo() method on data and pass this root's data as an argument to compare against.
        int answer = data.compareTo(root.getData()); //assign the the returned value to variable answer.
        //check if answer is negative number
        if (answer < 0)
            root.left = add(data, root.left); //if so, call add() method to insert this node to the left of the root.
        else if (answer > 0) //check and see if answer is positive number
            root.right = add(data, root.right); //if so, call add() method to insert this node to the right of the root.
        else // answer must be equal to 0 which indicates we found identical data that already exist in the tree.
        ; //in this case, ignore this duplicate value
        //method balance() is called, root node is passed
        //the returned value is returned.
        return balance(root);
    }

    /**
     * Precondition: An object of this class must be created and instantiated. The tree may be empty.
     * 				private method getNumOfNodes() must exist.	
     * Postcondition: private method getNumOfNodes() is called, root node is passed as an argument.
     * 					If the tree is not empty, number of nodes are counted and returned.
     * @param none
     * @return integer type number of nodes in the tree
     */
    public int getNumOfNodes() {
            //calling private method getNumOfNodes()
            //the root is passed as an argument
            //the return value will be returned.
            return getNumOfNodes(root);
        }
        /**
         * Precondition: An object of this class must be created and instantiated. The tree may be empty.
         * Postcondition: If the tree is not empty, number of nodes are counted and returned, otherwise 0 is returned.
         * @param none
         * @return integer type number of nodes in the tree
         */
    private int getNumOfNodes(AVLNode < KEY > root) {
        //check and see if the root is null
        if (root == null)
        //if so, return 0.
            return 0;
        else { //Otherwise, at least 1 node must exist
            //countNodes is local variable assigned with value of 1 (the root)
            int countNodes = 1;
            //method getNumOfNodes() is called recursively, countNodes is accumulating left children of this node
            countNodes += getNumOfNodes(root.left);
            //method getNumOfNodes() is called recursively, countNodes is accumulating right children of this node
            countNodes += getNumOfNodes(root.right);
            //countNodes, number of nodes in the tree is returned.
            return countNodes;
        }
    }

    /**
     * public method remove() to remove data item from an AVL tree
     * precondition: An AVL tree must exist. Or at least the root node is initialized. 
     *               thisElement must be passed and private method remove() must be exist.
     * postcondition: An AVL tree is searched looking for thisElement.
     * 					if an element is found, it will be deleted from an AVL tree.
     * 					The structure of the tree will be rearranged to satisfy an AVL tree property by calling method balance().
     * 					If an element is found and deleted, number of nodes in the tree are one less than what it was before, otherwise
     * 					 no changes in number of nodes in the tree. The structure of an AVL tree is maintained.
     * @param thisElement, element that should be deleted from the tree
     * @return void
     */
    public void remove(KEY thisElement) {
        //private method remove() is called, arguments thisElement and the root are passed
        //the returned value of method remove() call is assigned to root.
        root = remove(thisElement, root);
    }

    /**
     * Private method remove() to remove data item from an AVL tree
     * precondition: An AVL tree must exist. Or at least the root node is initialized. thisElement and root must be passed.
     * postcondition: An AVL tree is searched looking for thisElement.
     * 					if an element is found, it will be deleted from an AVL tree.
     * 					The structure of the tree will be rearranged to satisfy an AVL tree property by calling method balance().
     * 					If an element is found and deleted, number of nodes in the tree are one less than what it was before, otherwise
     * 					 no changes in number of nodes in the tree. The structure of an AVL tree is maintained.
     * @param thisElement, element that should be deleted
     * @param root
     * @return an AVLNode type node
     */
    private AVLNode < KEY > remove(KEY thisElement, AVLNode < KEY > root) {
        if (root == null) //check and see if the root is null
            return root; //if so, do nothing and return the root.
        //invoke compareTo() method on thisElement pass this root's data as an argument to compare against.
        int answer = thisElement.compareTo(root.getData());
        //check if answer is negative number    
        if (answer < 0)
            root.left = remove(thisElement, root.left); //call remove() method recursively and pass thisElement and left child of root.
        else if (answer > 0) //check if answer is positive number 
            root.right = remove(thisElement, root.right); //call remove() method recursively and pass thisElement and right child of root.
        else if (root.left != null && root.right != null) { //check if both children not equal to null value
            //if so, call method getMin() by passing right child of the root data
            //set the root data with the return value of getMin() method
            root.setData(getMin(root.right).getData());
            //set the root right child with the return value of remove() method, root data and root's right child is passed.
            root.right = remove(root.getData(), root.right);
        } else //Otherwise, check if left child of root is not null, if so root becomes root's left, else it becomes root's right. 
            root = (root.left != null) ? root.left : root.right;
        //call method balance() to balance the tree and pass the root node. return the returned value.
        return balance(root);
    }

    /**
     * Precondition: An object of this class must be created and instantiated.
     * 					The tree may contain some elements.
     * Postcondition: The root node is set to null. The tree is empty.
     * @param none
     * @return none
     */
    public void removeAVlTree() {
        //the root is assigned with null value.
        root = null;
    }

    /**
     * Precondition: An object of this class must be created and instantiated.
     * Postcondition: boolean value true is returned if the tree is empty, false otherwise.
     * @param none.
     * @return boolean value true or false.
     */
    public boolean isEmpty() { //if root is equal to null return true, false otherwise
            return root == null;
        }
        /**
         * Precondition: at least root of this tree must be exist. parameter thisTree must passed
         * 				this subtree may or may not be balanced.
         * Postcondition: max() method of Math class is invoked to return maximum height that is returned by method height().
         * 					rotateWithRightChild() and rotateWithLeftChild() are called to rotate unbalanced subtree.
         * 					thisNode is balanced and returned.
         * 				
         * @param thisTree
         * @return AVLNode type thisNode
         */
    private AVLNode < KEY > balance(AVLNode < KEY > thisTree) {
            //check if thisTree is null.
            if (thisTree == null)
                return thisTree; // if so, return thisTree
            //check and see if the difference of the height of left of thisTree and 
            //height of right of thisTree is bigger than ONE
            if (height(thisTree.left) - height(thisTree.right) > ONE)
                if (height(thisTree.left.left) >= height(thisTree.left.right)) //is the height of thisTree's left, left is >= height of thisTree left, right.
                    thisTree = rotateWithLeftChild(thisTree); //thisTree is assigned with the return value of method call rotateWithLeftChild().
                else //otherwise, 
                    thisTree = doubleWithLeftChild(thisTree); //thisTree is assigned with the return value of method call doubleWithLeftChild().
            else //otherwise, check and see if the difference of the height of right of thisTree and height of left of thisTree is bigger than ONE
            if (height(thisTree.right) - height(thisTree.left) > ONE)
                if (height(thisTree.right.right) >= height(thisTree.right.left)) //is the height of thisTree's right, right is >= height of thisTree right, left.
                    thisTree = rotateWithRightChild(thisTree); //thisTree is assigned with the return value of method call rotateWithRightChild().
                else //otherwise,
                    thisTree = doubleWithRightChild(thisTree); //thisTree is assigned with the return value of method call doubleWithRightChild().
                //the height of thisTree is reassigned with maximum height between left subtree and right subtree plus 1.
            thisTree.height = Math.max(height(thisTree.left), height(thisTree.right)) + 1;
            return thisTree; //return thisTree.
        }
        /**
         *Precondition: An object of this class must be exist. This tree may contain some data elements.
         *				private method checkBalance() must exist.
         *Postcondition: This tree is balanced and an AVL Tree properties are kept.
         *@param: none
         *@return: none
         */
    public void checkBalance() {
            //private method checkBalance() is called and parameter root is passed.
            checkBalance(root);
        }
        /**
         *Precondition: An object of this class must be exist. This tree may contain some data elements.
         *				Parameter root must be passed.
         *Postcondition: Methods checkBalance() and height() are called on a left and right children
         *				 This tree is balanced and an AVL Tree properties are kept.
         *@param: root
         *@return: integer type height
         */
    private int checkBalance(AVLNode < KEY > root) {
            //check if the root is null
            if (root == null)
                return -1; //if so, return -1
            //check and see if the root is not null
            if (root != null) {
                //if so, leftHeight is assigned with method checkBalance() call returned value of left child
                int leftHeight = checkBalance(root.left);
                //if so, rightHeight is assigned with method checkBalance() call returned value of right child
                int rightHeight = checkBalance(root.right);
                //evaluate if absolute value of the difference of left child height and right child height is bigger than 1 or
                //if left child's height is not equal to leftHeight or if right child's height is not equal to rihgtHeight.
                if (Math.abs(height(root.left) - height(root.right)) > 1 || height(root.left) != leftHeight || height(root.right) != rightHeight);

            }
            //method height() is called, root is passed as an argument, and
            //the returned value of this method call will be returned
            return height(root);
        }
        /**
         * Precondition: An object of this class must be created and instantiated.
         * 				private method getMin() must be exist.
         * Postcondition: private method getMin() is called and minimum value is returned if the tree in not empty.
         * 					Otherwise, new Exception will be thrown.
         * @return smallest item or null if empty.
         * @param none
         * @throws Exception 
         */
    public KEY getMin() throws Exception {
        if (isEmpty()) //check if this root is empty
            throw new Exception("Empty Tree!"); // if so, throw Exception.
        return getMin(root).getData(); // call private method getMin(), pass data of this root
    }

    /**
     * Precondition: An object of this class must be created and instantiated.
     * 				parameter root must be passed.
     * Postcondition: minimum value is found and returned if the tree in not empty.
     * @return the smallest item.
     * @param root
     */
    private AVLNode < KEY > getMin(AVLNode < KEY > root) {
        //check if the root is null
        if (root == null)
            return root; //if so, return root
        //while left of the root is not equal to null, repeat the loop
        while (root.left != null)
            root = root.left; // root is assigned to left child of the root node.
        return root; // return root
    }


    /**
     * Precondition: An object of this class must be created and instantiated.
     * 				private method getMax() must be exist.
     * Postcondition: private method getMin() is called and minimum value is returned if the tree in not empty.
     * 					Otherwise, new Exception will be thrown.
     * @return largest item within the tree.
     * @param none
     * @throws Exception 
     */
    public KEY getMax() throws Exception {
            if (isEmpty()) // check if the root is empty
                throw new Exception("Empty Tree!"); //if so, throw an Exception
            return getMax(root).getData(); //call private method getMax() and root's data is passed.
        }
        /**
         * Precondition: An object of this class must be created and instantiated.
         * 				parameter root must be passed.
         * Postcondition: maximum value is found and returned if the tree in not empty.
         * @return the largest item.
         * @param root
         */
    private AVLNode < KEY > getMax(AVLNode < KEY > root) {
        //check if the root is null
        if (root == null)
            return root; //if so, return root
        //while right of the root is not equal to null, repeat the loop
        while (root.right != null)
            root = root.right; //root is assigned with right child of root node.
        return root; //return root
    }

    /**
     * Precondition: an object of this class must be created and instantiated. thisElement must be passed.
     * 				private method search() must be exist.
     * Postcondition: returned boolean value of method search() call is returned.
     * @param thisElement, the item to search for.
     * @return boolean value true or false.
     */
    public boolean search(KEY thisElement) {
            //private method search() is called, thisElement and root are passed
            //the returned value will be returned.
            return search(thisElement, root);
        }
        /**
         * Precondition: two argument method search() is called.
         * 				data and root must be passed as an argument.
         * 				a binary tree must exist.
         * Postcondition: method compareTo() is invoked on data, data of the root is passed to compare against.
         * 					if data is found value true is returned. Otherwise, false is returned.
         * @param target
         * @return output
         *
         */
    private boolean search(KEY data, AVLNode < KEY > root) {
        //while loop will be executing repeatedly as long as root in not null.
        while (root != null) {
            //answer is assigned with integer value, comparison result of data against data of the root
            int answer = data.compareTo(root.getData());
            //if answer is negative number
            if (answer < 0)
                root = root.left; //root is assigned with left child of root.
            else if (answer > 0) // check if answer is positive number
                root = root.right; //root is assigned with right child of root.
            else //if answer is equal to 0, we found a match.
                return true; //true value is returned.
        }
        //otherwise, false value is returned.
        return false;
    }

    /**
     * Precondition: an object of this class must be created and instantiated.
     * 				parameter thisNode must be passed.
     * Postcondition: the height of thisNode or -1 is returned.
     * @param thisNode the parent of this subtree.
     * @return integer value height
     */
    private int height(AVLNode < KEY > thisNode) {
        //if thisNode is null -1 is returned, otherwise height of thisNode will be returned.
        return thisNode == null ? -1 : thisNode.height;
    }

    /**
     * Precondition: The tree must be exist. parameter thisNode must be passed.
     * Postcondition: thisNode is rotated once with left child, height is updated and newNode is returned.
     * @param thisNode
     * @return AVLNode newNode
     */
    private AVLNode < KEY > rotateWithLeftChild(AVLNode < KEY > thisNode) {
        //newNode is assigned with left child of thisNode
        AVLNode < KEY > newNode = thisNode.left;
        //thisNode is assigned with right child of newNode
        thisNode.left = newNode.right;
        //right child of newNode is thisNode
        newNode.right = thisNode;
        //thisNode's height is updated with a return value of method max() call of Math class 
        //by passing the height of left child and the height of right child plus 1.	
        thisNode.height = Math.max(height(thisNode.left), height(thisNode.right)) + 1;
        //newNode's height is updated with a return value of method max() call of Math class 
        //by passing the height of left child and thisNode's height plus 1.	
        newNode.height = Math.max(height(newNode.left), thisNode.height) + 1;
        //return newNode
        return newNode;
    }

    /**
     * Precondition: The tree must be exist. parameter thisNode must be passed.
     * Postcondition: thisNode is rotated once with right child, height is updated and newNode is returned.
     * @param thisNode
     * @return AVLNode newNode
     */
    private AVLNode < KEY > rotateWithRightChild(AVLNode < KEY > thisNode) {
        //newNode is assigned with right child of thisNode
        AVLNode < KEY > newNode = thisNode.right;
        //right child of thisNode is assigned with left child of newNode
        thisNode.right = newNode.left;
        //newNode's left child is assigned with thisNode
        newNode.left = thisNode;
        //thisNode's height is updated with a return value of method max() call of Math class 
        //by passing the height of left child and the height of right child plus 1.
        thisNode.height = Math.max(height(thisNode.left), height(thisNode.right)) + 1;
        //newNode's height is updated with a return value of method max() call of Math class 
        //by passing the height of right child and thisNode's height plus 1.	
        newNode.height = Math.max(height(newNode.right), thisNode.height) + 1;
        //newNode is returned.
        return newNode;
    }

    /**
     * Precondition: The tree must be exist. parameter thisNode must be passed.
     * 				methods rotateWithLefttChild() and rotateWithRightChild() must be exist.
     * Postcondition: thisNode is rotated twice with right child then with new left child, 
     * 					the height is updated and newNode is returned after method call rotateWithLeftChild().
     * @param thisNode
     * @return AVLNode type return of method rotateWithLeftChild() call
     */
    private AVLNode < KEY > doubleWithLeftChild(AVLNode < KEY > thisNode) {
        //thisNod's left child is assigned with a return value of method rotateWithRightChild() call.
        //left child of thisNode is passed as an argument
        thisNode.left = rotateWithRightChild(thisNode.left);
        //call method rotateWithLeftChild() and pass thisNode as an argument
        //the return value will be returned.
        return rotateWithLeftChild(thisNode);
    }

    /**
     * Precondition: The tree must be exist. parameter thisNode must be passed.
     * 				  methods rotateWithLefttChild() and rotateWithRightChild() must be exist.
     * Postcondition: thisNode is rotated twice with left child then with new right child, 
     * 					the height is updated and newNode is returned after method call rotateWithRightChild().
     * @param thisNode
     * @return AVLNode type return of method rotateWithRightChild() call
     */
    private AVLNode < KEY > doubleWithRightChild(AVLNode < KEY > thisNode) {
            //thisNod's right child is assigned with a return value of method rotateWithLefttChild() call.
            //right child of thisNode is passed as an argument
            thisNode.right = rotateWithLeftChild(thisNode.right);
            //call method rotateWithRightChild() and pass thisNode as an argument
            //the return value will be returned.
            return rotateWithRightChild(thisNode);
        }
        /**
         * Precondition: An AVL Tree must exist. Root of the tree, focusNode must be passed.
         * postcondition: All nodes in the tree are visited. Data elements of each node are printed in order form.
         * @return none
         * @param focusNode
         */
    public void inorderTraverseTree(AVLNode < KEY > focusNode) {
            //as long as focusNode is not null continue the recursive call
            if (focusNode != null) {

                // Traverse the left node recursively

                inorderTraverseTree(focusNode.left);

                // Visit the currently focused node and print out its data

                System.out.print(focusNode.getData() + " ");

                // Traverse the right node recursively

                inorderTraverseTree(focusNode.right);

            }

        }
        /**
         * Precondition: An AVL Tree must exist. Root of the tree, focusNode must be passed.
         * postcondition: All nodes in the tree are visited. Data elements of each node are printed in pre order form.
         * @return none
         * @param focusNode
         */
    public void preorderTraverseTree(AVLNode < KEY > focusNode) {
            //as long as focusNode is not null continue the recursive call
            if (focusNode != null) {
                // Visit the currently focused on node and print out its data
                System.out.print(focusNode.getData() + " ");
                // Traverse the left node recursively
                preorderTraverseTree(focusNode.left);
                // Traverse the right node recursively
                preorderTraverseTree(focusNode.right);

            }

        }
        /**
         * Precondition: An AVL Tree must exist. Root of the tree, focusNode must be passed.
         * postcondition: All nodes in the tree are visited. Data elements of each node are printed in post order form.
         * @return none
         * @param focusNode
         */
    public void postorderTraverseTree(AVLNode < KEY > focusNode) {
        //as long as focusNode is not null continue the recursive call
        if (focusNode != null) {

            // Traverse the left node recursively
            postorderTraverseTree(focusNode.left);
            // Traverse the right node recursively
            postorderTraverseTree(focusNode.right);
            // Visit the currently focused on node and print out its data
            System.out.print(focusNode.getData() + " ");

        }

    }

}
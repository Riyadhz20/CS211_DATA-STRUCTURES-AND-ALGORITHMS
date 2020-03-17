import java.util.LinkedList; 
import java.util.Queue; 
public class Tree {

    public static void main(String[] args) {

        BST T = new BST();
        T.insert(5);
        T.insert(3);
        T.insert(9);
        T.insert(1);
        T.insert(4);
        T.insert(6);
        System.out.println("Tree size is ="+T.size());
        System.out.println("The root of Bi-Tree is: " + (T.root()));
        System.out.println("In-order traversal sequence :");
        T.inOrder();
        /*System.out.println("Pre-order traversal sequence :");
        T.preOrder();
        System.out.println("Post-order traversal sequence :");
        T.postOrder();
        System.out.println("Level-order traversal sequence :");
        T.levelOrder();*/
        //test Homework 1
        System.out.println("delete the node 5");
         T.deleteNode(5);
         T.inOrder();
        //test Homework 2
        int max=  T.maxValue(T);
        System.out.println("Maximum value in the tree : "+max);
        System.out.println("In-order traversal sequence (after mirroring) :");
        T.mirror();
        T.inOrder();
        
         
         //test Homework 3
     
         T.insertByLevel(12);
         System.out.println("In-order traversal sequence after inser 12 by level");
         T.inOrder();
         
         // test Challenge Question 
         int max2=T.findMax(T);
          System.out.println("Maximum value in the tree : "+max);
     
    }
}

class BST {

    // Root node pointer. Will be null for an empty tree.
    private Node root;

    /*   * --Node-- The binary tree is built using this nested node class. Each node  
    * stores one data element, and has left and right sub-tree pointer which may be 
    * null. The node is a "dumb" nested class -- we just use it for storage; it  
    * does not have any methods.   */
    public static class Node {

        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    /**
     * Creates an empty binary tree -- a null root pointer.
     */
    public void BST() {
        root = null;
    }

    /**
     * Inserts the given data into the binary tree. Uses a recursive helper.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Recursive insert -- given a node pointer, recur down and insert the given
     * data into the tree. Returns the new node pointer (the standard way to
     * communicate a changed pointer back to the caller).
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } 
        else
            {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            }
            else
            {
                node.right = insert(node.right, data);
            }
        }
        return (node); // in any case, return the new pointer to the caller  
    }

    /**
     * Returns the number of nodes in the tree. Uses a recursive helper that
     * recurs down the tree and counts the nodes.
     */
    public int size() {
        return (size(root));
    }

    private int size(Node node) {
         if (node == null) 
            return 0; 
         else
            return(size(node.left) + 1 + size(node.right)); 
    }

    /**
     * Returns true if the given target is in the binary tree. Uses a recursive
     * helper.
     */
    public boolean lookup(int data) {
        return (lookup(root, data));
    }

    /**
     * Recursive lookup -- given a node, recur down searching for the given
     * data.
     */
    private boolean lookup(Node node, int data) {
        if (node == null) {
            return (false);
        }
        if (data == node.data)
        {
            return (true);
        } 
        else if (data < node.data) 
        {
            return (lookup(node.left, data));
        }
        else 
        {
            return (lookup(node.right, data));
        }
    }

    /**
     * Prints the node values in the "inorder" order. Uses a recursive helper to
     * do the traversal.
     */
    public void inOrder() {
        inorderTree(root);
        System.out.println();
    }

    private void inorderTree(Node node) {
        if (node == null) {
            return;
        }
        // left, node itself, right 
        inorderTree(node.left);
        System.out.print(node.data + "  ");
        inorderTree(node.right);
    }

    /**
     * Prints the node values in the "preOrder" order. Uses a recursive helper
     * to do the traversal.
     */
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    public void preOrder(Node node) {
         if (node == null) {
            return;
        }
          // node itself,left, right 
        System.out.print(node.data + "  ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Prints the node values in the "postOrder" order. Uses a recursive helper
     * to do the traversal.
     */
    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    public void postOrder(Node node) {
         if (node == null) {
            return;
        }
         //left, right, node itself 
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + "  ");

    }

    /**
     * * Prints the node values in the "levelOrder" order. Uses a helper to do
     * the traversal.
     *
     */
    public void levelOrder() {
        levelOrder(root);
        System.out.println();
    }

    public void levelOrder(Node node) { // BFS
        if (node != null) {
            LinkedQueue q = new LinkedQueue<Node>();
            q.enqueue(node);
            while (q.size() != 0) {
                Node currentNode = (Node) q.dequeue();
                System.out.print(currentNode.data + "  ");
                if (currentNode.left != null) {
                    q.enqueue(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.enqueue(currentNode.right);
                }
            }
        }
    }

    /**
     * Changes the tree into its mirror image. Uses a recursive helper that
     * recurs over the tree, swapping the left/right pointers.
     */
    public void mirror() {

       mirror(root);
    }

    private Node mirror(Node node) {
        if (node == null) 
            return node; 
  
        /* do the subtrees */
        Node left = mirror(node.left); 
        Node right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
    }

    public int root() { 
        // TODO Auto-generated method stub 
        return root.data;
    }
    
    //Homework 1
// This method mainly calls deleteRec() 
    void deleteNode(int key) 
    { 
        root = deleteNode(root, key); 
    } 
  
    /* A recursive function to insert a new key in BST */
    Node deleteNode(Node node, int key) 
    { 
        /* Base Case: If the tree is empty */
        if (node == null)  return node; 
  
        /* Otherwise, recur down the tree */
        if (key < node.data) 
            node.left = deleteNode(node.left, key); 
        else if (key > node.data) 
            node.right = deleteNode(node.right, key); 
  
        // if key is same as node's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (node.left == null) 
                return node.right; 
            else if (node.right == null) //there is not else***************
                return node.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            node.data = min(node.right); 
  
            // Delete the inorder successor 
            node.right = deleteNode(node.right, node.data); 
        }
        return node; 
    } 
     /*int minValue(Node root) 
    { 
        int minv = root.data; 
        while (root.left != null) 
        { 
            minv = root.left.data; 
            root = root.left; 
        } 
        return minv; 
    } */
    int min(Node node){
        if(node.left == null)
        return node.data;

        return min(node.left);

    }
  
 // Homework  2
    public  int maxValue(BST T) 
{  
    /* loop down to find the rightmost leaf */
    Node current = T.root; 
    while (current.right != null)  
    current = current.right; 
      
    return (current.data); 
} 
    
    
    
    
    //Challenge Question 
     public  int findMax(BST T) {
     
     return findMax(T.root);
     
     }
    // Returns the max value in a binary tree 
   public  int findMax(Node node) 
    { 
        if (node == null) 
            return Integer.MIN_VALUE; 
  
        int res = node.data; 
        int lres = findMax(node.left); 
        int rres = findMax(node.right); 
  
        if (lres > res) 
            res = lres; 
        if (rres > res) 
            res = rres; 
        return res; 
    } 
   
   
   //Homework 3
   /*function to insert element in binary tree */
    public void insertByLevel( int key) 
    { 
        Node temp=root;
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new Node(key); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new Node(key); 
                break; 
            } else
                q.add(temp.right); 
        } 
    } 
       
}

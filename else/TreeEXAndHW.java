
package treeexandhw;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


public class TreeEXAndHW {

    public static void main(String[] args) {
        
         BST T = new BST();
         
         T.insert(5);
         T.insert(3);
         T.insert(9);
         T.insert(1);
         T.insert(4);
         T.insert(6);

         System.out.println("The root of Bi-Tree is: " + (T.root()));
         System.out.println("In-order traversal sequence :");
         T.inOrder();
         System.out.println("Pre-order traversal sequence :");
         T.preOrder();
         System.out.println("Post-order traversal sequence :");
         T.postOrder();
         
         System.out.println("Level-order traevsal sequence ");
         T.levelOrder();
         
         System.out.println("In-order traversal sequence (after mirroring) :"); 
         T.mirror();
         T.inOrder(); 
         
         System.out.println("\nThe Size of Tree is "+T.size()); 
         
         System.out.println("After Deleting From Tree :- " );
         T.DeleatEl(5);
         T.inOrder();
         
         T.insertByLevel(30);
         System.out.println("The Tree  after inser 30 by level");
         T.inOrder();

         System.out.println("The Maximum value in the Tree is " +  T.findMax(T.root));
         
         System.out.println("The Root oafter delete is: " + (T.root()));
        
 
    }
}
 
    class BST{
        
        public Node root;

        
        public void BST() {
        root = null;
        }

        public void insert(int data) {
        root = insert(root, data);
      }
        
        private Node insert(Node node, int data) {
         if (node == null) {
         node = new Node(data);
         } else {
         if (data <= node.data) {
         node.left = insert(node.left, data);
         } else {
         node.right = insert(node.right, data);
          }
       }
        return (node); // in any case, return the new pointer to the caller
      }
        
        public int size() {
         return (size(root));
      }
        private int size(Node node) {
            if(node==null)
                 return 0;
         else
            return(size(node.left)+1+size(node.right));
                 
     }
        
        public boolean lookup(int data) {
        return (lookup(root, data));
       }
        
        private boolean lookup(Node node, int data) {
          if (node == null) {
           return (false);
             }
          if (data == node.data) {
          return (true);
       } else if (data < node.data) {
         return (lookup(node.left, data));
       } else {
       return (lookup(node.right, data));
        }
      }
        
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
          System.out.print(node.data + " ");
          inorderTree(node.right);
       }
          
          
        public void preOrder() {
           preOrder(root);
          System.out.println();
          }
         
        public void preOrder(Node node) {
           if (node == null) {
           return;
             }
          System.out.print(node.data+" ");
          preOrder(node.left);
          preOrder(node.right);
 
       }
         
         
        public void postOrder() {
         postOrder(root);
         System.out.println();
       }
         
        public void postOrder(Node node) {
           if (node == null) {
           return;
          }
           postOrder(node.left);
           postOrder(node.right);
           System.out.print(node.data+" ");
       }
        
        public void levelOrder(){
          levelOrder(root);
          System.out.println();
        }
      
        public void levelOrder(Node node){
          if (node != null){
              Queue<Node> q = new ArrayDeque<Node>();
              q.add(node);
              while (q.size() !=0){
                  Node curNode = q.remove();
                  System.out.println(curNode.data+" ");
                  if(curNode.left != null){
                      q.add(curNode.left);
                  }
                  if(curNode.right != null){
                      q.add(curNode.right);
                  }
              }
          }
      }
        
        public int root() {  
            return root.data; 
        } 
    
        public void mirror() { 
            root = mirror(root);
            
        }
        
        private Node mirror(Node node) { 
            
            if(node==null)
            return node;
            
            Node L = mirror(node.left);
            Node R = mirror(node.right);
            node.left = R;
            node.right = L;
            
            return node;
        }
        
        public void DeleatEl(int elm){
            
            Node node , p = root , preveas = null;
            
            while ( p != null && p.data != elm){
                preveas = p;
                if(p.data < elm ){
                    p = p.right;
                } else {
                    p = p.left;
                }
            }
            
  //**************************************************************************//
            node = p;
            if( p != null && p.data == elm ){
                if(node.right == null)
                    node = node.left;
                else if(node.left == null)
                    node = node.right;
                else{
                    Node tmp = node.left;
                    Node sectmp = node;
                    while(tmp.right != null){
                        sectmp = tmp ;
                        tmp = tmp.right;
                     }
                   node.data = tmp.data;
                   if (sectmp == node)
                       sectmp.left = tmp.left;
                   else
                       sectmp.right = tmp.left;  
                 }
                if (p == root){
                    root = node;
                 }
                else if(preveas.left == p)
                    preveas.left = node;
                else
                    preveas.right = node;
             }
          
            else if (root != null)
                System.out.println("The Elelemnt = " + elm +" is not in the Tree");
            else
                System.out.println("The Tree is Empty !");
        }
         
        
        public int findMax(Node node){ 
        if (node == null) 
         return Integer.MIN_VALUE; 
  
        int max = node.data; 
        int Lside = findMax(node.left); 
        int Rside = findMax(node.right); 
  
        if (Lside > max) 
            max = Lside; 
        if (Rside > max) 
            max = Rside; 
        return max; 
    } 
      
        public void insertByLevel( int Elme){ 
        Node temp=root;
        Queue<Node> node = new LinkedList<Node>(); 
        node.add(temp); 
     
        while (!node.isEmpty()) { 
            temp = node.peek(); 
            node.remove(); 
       
            if (temp.left == null) { 
                temp.left = new Node(Elme); 
                break; 
            } else
                node.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new Node(Elme); 
                break; 
            } else
                node.add(temp.right); 
        } 
    } 
    
    }
    

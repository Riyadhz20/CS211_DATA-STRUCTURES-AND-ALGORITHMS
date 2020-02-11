package lab5;

public class DoublyLinkedListApplication {

    public static void main(String[] args) {

        /* Start with the empty list */
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertLast("One");
        dll.insertLast("Two");
        dll.insertFirst("Three");
        dll.insertFirst("Four");
        dll.InsertAfter("Three", "Five");
        dll.insertFirst("Six");
        dll.insertLast("Seven");
        dll.printlist(dll.head);
        String target = "Seven";
        System.out.println(dll.deleteNode(target) ? target + " Found and deleted successfuly!" : target + " Not Found!");
        dll.printlist(dll.head);
        target = "Nine";
        System.out.println(dll.deleteNode(target) ? target + " Found and deleted successfuly!" : target + " Not Found!");
        target = "One";
        System.out.println(dll.deleteNode(target) ? target + " Found and deleted successfuly!" : target + " Not Found!");
        target = "Six";
        System.out.println(dll.deleteNode(target) ? target + " Found and deleted successfuly!" : target + " Not Found!");
        dll.printlist(dll.head);
        System.out.println("Size if The list is " + dll.getCount());

    }

}

class DoublyLinkedList {

    DNode head; // head of list 
    DNode tail;// tail of list 

    // Adding a node at the front of the list 
    public void insertFirst(String new_data) {
        /* 
        * 1. allocate node 
          2. put in the data    */
        DNode new_Node = new DNode(new_data);
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null) {
            head.prev = new_Node;
        }
        /* 5. move the head to point to the new node */
        head = new_Node;
    }

    //Exercises  1
    // Add a node at the end of the list  
    void insertLast(String new_data) {

        if (head == null) {
            head = new DNode(new_data);
            tail = head;
        } else {

            DNode n = new DNode(new_data);
            DNode w = tail;
            n.setPrev(w);
            n.setNext(null);
            w.setNext(n);
            tail = n;
        }

    }
    //Exercises  2
    public void printlist(DNode node) {
        DNode last = null;
        System.out.println("Traversing the Doubly Linked List in forward Direction");
        while (node != null) {
            System.out.print(node.element + " ");
            last = node;

            node = node.next;
        }
        System.out.println();
        System.out.println("Traversing the Doubly Linked List in reverse direction");
        while (last != null) {
            System.out.print(last.element + " ");

            last = last.prev;
        }
        System.out.println();

    }
    //Homework 1
    // delete a node in a Doubly Linked List.  
    boolean deleteNode(String target) {
        //1. list is empty
        if (head == null) {
            System.out.println("List is empty!!");
            return false;
        }
        //2.if target element is the first element
        if (head.getElement().equals(target)) {
            DNode v = head.getNext();
            head = v;
            head.setPrev(null);
            return true;
        }
        //3. list not empty and target not in the head
        DNode cur = head;
        while (!(cur.getElement().equalsIgnoreCase(target)) && cur.getNext() != null) {
            cur = cur.next;
        }
        // target node at the end of list

        if (cur.getNext() == null && !cur.getElement().equalsIgnoreCase(target)) {
            return false;
        }
        if (cur.getNext() == null && cur.getElement().equalsIgnoreCase(target)) {
            DNode v = cur.getPrev();
            v.setNext(null);
            tail = v;
            cur.setNext(null);
            cur.setPrev(null);

            return true;
            // target node at the middle of list
        } else {

            DNode v = cur.getPrev();
            DNode u = cur.getNext();
            v.setNext(u);
            u.setPrev(v);
           
            cur.setPrev(null);
            cur.setNext(null);

            return true;
        }

    }
    //Homework 2
    public void InsertAfter(String string, String string2) {

        DNode cur = head;
        // we need to search until we find the right location to insert the node
        while (cur.getNext() != null && !cur.getElement().equalsIgnoreCase(string)) {
            cur = cur.getNext();
        }
        if (!cur.getElement().equalsIgnoreCase(string)) {
            System.out.println("Can not find " + string);
        } else {
            DNode newNode = new DNode(string2);
            DNode w = cur.getNext();
            newNode.setPrev(cur);
            newNode.setNext(w);
            cur.setNext(newNode);
            w.setPrev(newNode);

        }

    }
   //Challenge Question 
    public int getCountRec(DNode node) {
        // Base case 
        if (node == null) {
            return 0;
        }

        // Count is this node plus rest of the list 
        return 1 + getCountRec(node.next);
    }
    /* Wrapper over getCountRec() */
    public int getCount() {
        return getCountRec(head);
    }

}

/* DNode of a doubly linked list of strings */
class DNode {

    protected String element; // String element stored by a node 

    protected DNode next, prev; // Pointers to next and previous nodes 

    /* Constructor that creates a node with given fields */
    public DNode(String e) {

        element = e;

        prev = null;

        next = null;
    }

    /* Returns the element of this node */
    public String getElement() {
        return element;
    }

    /* Returns the previous node of this node */
    public DNode getPrev() {
        return prev;
    }

    /* Returns the next node of this node */
    public DNode getNext() {
        return next;
    }

    /* Sets the element of this node */
    public void setElement(String newElem) {
        element = newElem;
    }

    /* Sets the previous node of this node */
    public void setPrev(DNode newPrev) {
        prev = newPrev;
    }

    /* Sets the next node of this node */
    public void setNext(DNode newNext) {
        next = newNext;
    }

}

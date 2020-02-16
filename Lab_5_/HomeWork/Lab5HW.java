package lab5.hw;

public class Lab5HW {
    public static void main(String[] args) {
        
    DoublyLinkedList D = new DoublyLinkedList();
        D.insertFirst("A");
        D.insertFirst("B");
        D.insertFirst("C");
        D.insertFirst("D");
        D.insertFirst("E");
        D.insertLast("a");
        D.printlist(D.head); 
        
        D.InsertAfter("a", "E");
        
        D.deleteNode("A");
        D.printlist(D.head);
    }
}

class DoublyLinkedList {

    DNode head;

    public void insertFirst(String new_data) {
        /*
        * 1. allocate node 2. put in the data
        */
        DNode new_Node = new DNode(new_data);
        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;
        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;
        /* 5. move the head to point to the new node */
        head = new_Node;
    }
    void insertLast(String new_data) {
        DNode new_Node = new DNode(new_data);
        DNode C = head;
        for(;C.next != null;C = C.next);
        new_Node.next = null;
        C.next = new_Node;
        new_Node.prev = C;
    }
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
        while(last != null){
            System.out.print(last.element + " ");
            node = last;
            last = last.prev;
        }
        System.out.println();
    }
    public void InsertAfter(String string, String string2) {
        DNode W = new DNode(string);
        DNode C = head;
        DNode F = head;
        
        for(;C.element != string2;C = C.next);
        F = C.next;
        
        W.next = C.next;
        C.next.prev = W;
        C.next = W;
        W.prev = C;
        
        System.out.println("\n----------------\nAfter Insert");
        printlist(head);
    }
    boolean deleteNode(String target) {
        DNode C = head;
        DNode F ;
        DNode P ;
        for(;C.element != target;C = C.next);
        if(C.element == target){
            if(C == head){
                head = head.next;
                head.prev = null;
            }else if (C.next == null){
                P = C.prev;
                P.prev = C.prev.prev;
                
                C.prev.next=P;
                P.next = null;
            }else{
                P = C.prev;
                F = C.next;
                
                F.prev = P;
                P.next = F;
                
                F.next = C.next.next;
                P.prev = C.prev.prev;
            }
            return true;
        }else 
            return false;
    }
}
class DNode {

    public String element;
    public DNode next, prev;
    
    public DNode(String e) {
        element = e;
        prev = null;
        next = null;
    }
}

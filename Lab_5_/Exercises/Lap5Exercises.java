package lap5.exercises;

public class Lap5Exercises {
    
    public static void main(String[] args) {
    DoublyLinkedList D = new DoublyLinkedList();
        D.insertFirst("A");
        D.insertLast("a");
        D.printlist(D.head);  
    }
}

class DoublyLinkedList {
    
    DNode head;
    
    public void insertFirst(String new_data) {
    DNode new_Node = new DNode(new_data);
    new_Node.next = head;
    new_Node.prev = null;
    if (head != null)
        head.prev = new_Node;
    head = new_Node;
    }
    //------------------------------------------
    public void insertLast(String new_data) {
        
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
        //------------------------------------------------------------------      
        while(last != null){
            System.out.print(last.element + " ");
            node = last;
            last = last.prev;
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
}



package lap4.ex;


public class Lap4Ex {
    
    public static void main(String[] args) {
        SingleLinkedList Sll = new SingleLinkedList();
        Sll.insertFirst(15);
        Sll.displayList();
        
        Sll.insertFirst(25);
        Sll.displayList();
        
        Sll.insertLast(35);
        Sll.displayList();
        
        Sll.insertLast(45);
        Sll.displayList();
        
        Sll.displayList();
        
        Sll.displayList();
        
        Sll.displayList();
        
        Sll.insertFirst(75);
        Sll.displayList();
        
        Sll.deleteFirst();
        Sll.displayList();
        
        Sll.deleteLast();
        Sll.displayList();
        
        Sll.deleteAfterNode(55);
        Sll.displayList();
        
        Sll.deleteAfterNode(25);
        Sll.displayList();
        
    }
    
}

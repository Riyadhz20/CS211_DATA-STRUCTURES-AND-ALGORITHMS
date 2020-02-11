/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lap4.exercises;

public class Lap4Exercises {
    
    public static void main(String[] args) {
        SingleLinkedList Sll = new SingleLinkedList();
        Sll.insertFirst(15);
        Sll.displayList();
        Sll.count();
        
        Sll.insertFirst(25);
        Sll.displayList();
        Sll.count();
        
        Sll.insertLast(35);
        Sll.displayList();
        Sll.count();
        
        Sll.insertLast(45);
        Sll.displayList();
        Sll.count();
        
        Sll.displayList();
        Sll.count();
        
        Sll.displayList();
        Sll.count();
        
        Sll.displayList();
        Sll.count();
        
        Sll.insertFirst(75);
        Sll.displayList();
        
        Sll.deleteFirst();
        Sll.displayList();
        Sll.count();
        
        Sll.deleteLast();
        Sll.displayList();
        Sll.count();
        
        Sll.deleteAfterNode(55);
        Sll.displayList();
        Sll.count();
        
        Sll.deleteAfterNode(25);
        Sll.displayList();
        Sll.count();
        
        Sll.displayPreSucc(35);
        
    }
}


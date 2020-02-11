package lap4.exercises;


public class SingleLinkedList {
    
    Node head;
    
    
    void insertFirst(int data){
        if (head == null)
            head = new Node(data);
        else{
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        
    }
    void insertLast(int data){
        if (head == null)
            head = new Node(data);
        else{
            Node cur = head;
            for(; cur.next != null; cur = cur.next)
                ;
            Node newNode = new Node(data);
            cur.next = newNode;
        }
    }
    void insertAfterNode(int prevData, int newData){
        Node cur = head;
        while (cur.next != null && cur.data != prevData)
            cur = cur.next;
        Node newNode = new Node(newData);
        newNode.next = cur.next;
        cur.next = newNode;
    }
    void deleteFirst(){
        if(head != null)
            head = head.next;
        else
            System.out.println("List is empty");
    }
    void deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node cur = head;
        for(; cur.next.next != null; cur = cur.next);
        cur.next = null;
    }
    void deleteAfterNode(int prevData){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node cur = head;
        while(cur.next.next != null && cur.data != prevData)
            cur = cur.next;
        if(cur.data != prevData)
            System.out.println("List does not contain the target node or the target node is the last node!");
        else
            cur.next = cur.next.next;
    }
    void displayList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("/");
    }
    void count(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        int i = 0;
        Node cur = head;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        System.out.println("Numder of Nodes Now: "+i);
    }
    void displayPreSucc(int data){
        
        Node cur = head;
        while(cur != null){
            if(cur.data == data){
                System.out.println("There is no Predecessor");
                System.out.println("The Node is: " +cur.data);
                
                if(cur.next != null)
                    System.out.println("The Successor is "+cur.next.data);
                else
                    System.out.println("There is no Successor");
                return;
            }
            else if(cur.next == null){
                System.out.println("The list is empty or not found ");
                return;
            }
            else if (cur.next.data == data){
                
                System.out.println("The Predecessor is: "+cur.data);
                System.out.println("The Node is: " +cur.next.data);
                
                if(cur.next.next != null)
                    System.out.println("The Successor is "+cur.next.next.data);
                else
                    System.out.println("The Successor is null");
                return;
            }
            else
                cur = cur.next;
        }
    }
}

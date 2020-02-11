package lab4;

class SingleLinkedList {

    Node head;

    /*
* this is an example implementation of some of the basic operations of the
* simple linked list. the implementation of double linked list operations is
* similar, just remember that you are dealing with two pointers in each node object.
     */
// you can add a tail pointer to point always to the last node in the linked
// list
    void insertFirst(int data) {// creates the node within the method
	if (head == null) {
	    head = new Node(data);
	} else {
	    Node newNode = new Node(data);
	    newNode.next = head;
	    head = newNode;
	}
    }

    void insertLast(int data) {
	if (head == null) {
	    head = new Node(data);
	} else {
	    Node cur = head;
	    for (; cur.next != null; cur = cur.next)
;
// this for segment does nothing but traversing to the last node in
// the list
// if we keep a tail pointer, we will directly write t.next =
// newNode;
	    Node newNode = new Node(data);
	    cur.next = newNode;
	}
    }

    void insertAfterNode(int prevData, int newData) {
	Node cur = head;
// we need to search until we find the right location to insert the node
	while (cur.next != null && cur.data != prevData) {
	    cur = cur.next;
	}
	Node newNode = new Node(newData);
	newNode.next = cur.next;
	cur.next = newNode;
    }

    void deleteFirst() {
	if (head != null) {
	    head = head.next;
	} else {
	    System.out.println("List is empty!!");
	}
    }

    void deleteLast() {
	if (head == null)// another way to test
	{
	    System.out.println("List is empty!!");
	    return;
	}
	Node cur = head;
	for (; cur.next.next != null; cur = cur.next)
;
// this for segment does nothing but traversing to the node
// before the last node in the list
	cur.next = null;
    }

    void deleteAfterNode(int prevData) {
	if (head == null) {
	    System.out.println("List is empty!!");
	    return;
	}
	Node cur = head;
	while (cur.next.next != null && cur.data != prevData) {
	    cur = cur.next;
	}
	if (cur.data != prevData) {
	    System.out.println("List does not contain the target node or the target node is the last node!");
	} else {
	    cur.next = cur.next.next;
	}
    }

    void displayList() {
	if (head == null) {
	    System.out.println("List is empty!!");
	    return;
	}
	Node cur = head;
	while (cur != null) {
	    System.out.print(cur.data + " -> ");
	    cur = cur.next;
	}
	System.out.println("/");
    }
//Exercises 1

    public int count() {
	Node temp = head;
	int count = 0;
	while (temp != null) {
	    count++;
	    temp = temp.next;
	}
	return count;
    }
    //Exercises 2

    public void displayPreSucc(int val) {
	Node cur = head;
	while (cur.next != null && cur.next.data != val) {
	    cur = cur.next;
	}
	if (cur.next.next != null) {
	    System.out.println("Prev is " + cur.data + " current is " + cur.next.data + " Succ is " + cur.next.next.data);
	}

    }
    //Homework

    void getUnion(SingleLinkedList list1, SingleLinkedList list2) {
	Node t1 = list1.head, t2 = list2.head;

	//print all elements of list1 in the result 
	while (t1 != null) {
	    print(t1.data);
	    t1 = t1.next;
	}
	// print those elements of list2 that are not present in list1

	while (t2 != null) {
	    Node t = list1.head;
	    boolean found = false;
	    while (t != null) {
		if (t.data == t2.data) {
		    found = true;
		    break;
		}
		t = t.next;

	    }
	    if (!found) {
		print(t2.data);
	    }
	    t2 = t2.next;

	}
    }

    /*  Inserts a node at start of linked list */
    void print(int data) {
	System.out.print(data + " ");
    }
    // intersection

    void getIntersection(SingleLinkedList list1, SingleLinkedList list2) {

	Node t1 = list1.head;

	while (t1 != null) {
	    Node t2 = list2.head;

	    while (t2 != null) //20 35 25 // 0 20 2
	    {
		if (t1.data == t2.data) {
		    print(t1.data);
		    break;
		} else {
		    t2 = t2.next;
		}

	    }
	    t1 = t1.next;

	}
    }

    //Challenge Question
    public void reverse() {
	Node prev = null;
	Node current = head;
	Node next = null;
	while (current != null) {
	    next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}
	head = prev;

    }
}

class Node {

    int data;
    Node next = null;

    Node(int d) {
	data = d;
    }
}

public class SingleLinkedListApplication {

    public static void main(String[] args) {
	SingleLinkedList sll = new SingleLinkedList();
	sll.insertFirst(15);
	sll.displayList();
	sll.insertFirst(25);
	sll.displayList();
	sll.insertLast(35);
	sll.displayList();
	sll.insertLast(45);
	sll.displayList();
	sll.displayList();
	sll.displayList();
	sll.displayList();
	sll.insertFirst(75);
	sll.displayList();
	sll.deleteFirst();
	sll.displayList();
	sll.deleteLast();
	sll.displayList();
	sll.deleteAfterNode(55);
	sll.displayList();
	sll.deleteAfterNode(25);
	sll.displayList();
//test count method
	System.out.println(sll.count());
	sll.insertLast(20);
	sll.displayList();
	//test displayPreSucc method
	sll.displayPreSucc(35);

	// test getUnion method
	SingleLinkedList sll2 = new SingleLinkedList();
	sll2.insertLast(0);
	sll2.insertLast(20);
	sll2.insertLast(2);
	sll2.displayList();
	sll.getUnion(sll, sll2);
	//test getIntersection method

	System.out.println("");
	sll.getIntersection(sll, sll2);

	//test  reverse method
	sll.reverse();
	sll.displayList();

    }
}

package lab6.hw;

import java.util.LinkedList;
import java.util.Scanner;
import lab6.hw.Lab6HW.StackInterface;

public class Lab6HW {

    final static int STACK_SIZE = 10;
    
    public static void main(String[] args) {
        
        
        
        Scanner read = new Scanner(System.in);
        Stack s = new Stack(STACK_SIZE);
        LinkedStack L = new LinkedStack();
        
        char ch;
        System.out.println("Enter 10 characters:");
        
        
        for (int i = 0; i < STACK_SIZE; i++) {
            ch = read.next().charAt(0);
            if (!s.isFull()){
                L.push(ch);
                s.push(ch);
            }
        }
        
        while (!L.isEmpty())
            System.out.print(L.pop());
        System.out.println();
        
        s.displayStack(s);
        
        s = (Stack)s.reverseStack(s);
        
        while (!s.isEmpty())
            System.out.print(s.pop());
        

    }
    
    public interface StackInterface<E> {
        public boolean isEmpty();
        public E peek();
        public E pop();
        public void push(E element);
        public int size();
    }
}

class Stack {
   
    private int maxStack;
    private int emptyStack;
    private int top;
    private char[] items;

    public Stack(int size) {
        maxStack = size;
        emptyStack = -1;
        top = emptyStack;
        items = new char[maxStack];
    }
    public void push(char c) {
        items[++top] = c;
    }
    public char pop() {
        return items[top--];
    }
    public boolean isFull() {
        return top + 1 == maxStack;
    }
    public boolean isEmpty() {
        return top == emptyStack;
    }
    
    public Object reverseStack(Stack F){
        Stack R1 = new Stack(F.maxStack);
        while (!F.isEmpty())
            R1.push((char)F.pop());
        System.out.println("SUCCESSED...!");
        return R1;
    }
    
    public void  displayStack(Stack stack){
        if(stack.isEmpty()){
            System.out.println("stack is Empty");
        }
        else{
            int L = stack.top;
            while(L != stack.emptyStack ){
                System.out.print(items[L]);
                L--;
            }
            System.out.println();
        }
    }
}
class ArrayStack<E> implements StackInterface<E> {
    
    private E[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 100;
    
    public ArrayStack() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
    }
    public ArrayStack(int capacity) {
        elements = (E[]) new Object[capacity];
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public E peek() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }
        return elements[size - 1]; // top of stack
    }
    public E pop() {
        if (size == 0) {
            throw new java.util.EmptyStackException();
        }
        E element = elements[--size];
        elements[size] = null;
        return element;
    }
    public void push(E element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }
    public int size() {
        return size;
    }
    private void resize() {
        assert size == elements.length;
        Object[] a = new Object[2 * size];
        System.arraycopy(elements, 0, a, 0, size);
        elements = (E[]) a;
    } 
}
class LinkedStack {
    LinkedList F;
    int Prec;
    
    public LinkedStack(){
        F = new LinkedList();
        this.F = F;
    }
    public LinkedStack(char i){
        
    }
    public boolean isEmpty() {
        return (F.size() == 0);
    }
    public boolean isFull(){
        return false;
    }
    public void push(char n){
        F.addFirst(n);
    }
    public char pop(){
        
        return (char) F.removeFirst();
    }
    public int size() {
        return F.size();
    }
    public void Display(){
        while(!F.isEmpty()){
            Character temp = (Character)F.pop();  
            System.out.println(temp);
        }
    }
    
}

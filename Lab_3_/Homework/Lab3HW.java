package lab3.hw;

import java.util.Scanner;

public class Lab3HW {
    
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Integer Number: ");
        int N = input.nextInt();
        System.out.println(N+"^"+N+"= "+crazySum(N));
        
        System.out.print("How Long the Array? ");
        int [] num = new int [input.nextInt()];
        
        System.out.println("Enter The " +num.length +" Elements In The Array: ");
        
        for(int i = 0; i < num.length ;i++){
            num[i] = input.nextInt();
        }
        
        System.out.print("What is the Number do u want to find in Array: ");
        
        
        System.out.println("The Number is found: " +search(num ,0 ,num.length ,input.nextInt()));
    }
    public static int crazySum(int x) {
        if(x == 1){
            return 1;
        }
        else{
            return ((int)Math.pow(x , x) + crazySum(x - 1));
        }
    }
    public static boolean search(int [] A , int i , int l , int f){
        
        if(l==0 || i == l)
            return false;
        
        else if(A[i] == f)
            return true;
        
        return search (A, i+1 , l , f);
        
    }
}

package lab3.excercises;

import java.util.Scanner;

/**
 *
 * @author Riyad
 */
public class Lab3Excercises2 {
    public static void main(String[] args) {
        String S;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a string: ");
        
        S = read.nextLine();
        int i =S.length();
        System.out.println(isPalindrome(S,0,3));
        
    }
    public static Boolean isPalindrome(String S, int i, int e){
        
        if(S.charAt(i) != S.charAt(S.length())){
            return false;
        } if(i<e+1) {
            return isPalindrome(S,i++,e--);
        }
        return true;
    }
    
    
}

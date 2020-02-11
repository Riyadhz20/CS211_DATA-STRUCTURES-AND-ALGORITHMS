package lab3;

import java.util.Scanner;

public class Lab32 {

    public static void main(String[] args) {
        String str;
        Scanner read = new Scanner(System.in);
        System.out.println("Enter a string: ");
        str = read.nextLine();
        System.out.println("original: "+str + "; reversed: " + reverseString(str));
    }

    public static String reverseString(String str){
        
        if(str.isEmpty()){
            return str;
        } else {
            
            return reverseString(str.substring(1))+str.charAt(0);
        }
    }
}

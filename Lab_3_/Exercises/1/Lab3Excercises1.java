package lab3.excercises;

import java.util.Scanner;

/**
 *
 * @author Riyad
 */
public class Lab3Excercises1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        System.out.println("Use integers only.");
        System.out.println("Enter a Number: ");
        
        int num = read.nextInt();
        int R = digitSum(num);
        System.out.print(R);
        
    }
    public static int digitSum(int n){
        int R;
        if(n == 0)
            return n;
        else{
            
            return n%10 +digitSum(n/10);
        }
    }
    
}

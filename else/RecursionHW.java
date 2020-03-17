
package recursionhw;

import java.util.Scanner;


public class RecursionHW {

    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.println("Please Enter Integer Number For Power :-");
        int i = input.nextInt();
        System.out.println(i+" Power of "+i+" = "+powernum(i));
        
        System.out.println("How many Element you need in The Array ?");
        
        int a = input.nextInt();
        int [] Num = new int [a] ;
        
        
        System.out.println("Enter The Elements In The Array:-");
        
        for(int b = 0; b < Num.length ;b++){
            Num[b] = input.nextInt();
        }
        
        System.out.println("Enter The Number you need to Find it :-");
        int j = input.nextInt();
        
        boolean value = Searching( Num , 0 , Num.length , j );
        
        if (value == true){
            System.out.println(" The Number " + j + " is Found at the Value ");
        }
        else{
            System.out.println(" The Number " + j + " is not Found");
        }

    }

   public static int powernum(int x) {
        if(x == 1){
            return 1;
        }
        else{
            return ((int)Math.pow(x , x) +powernum(x - 1));
        }
   }
   public static boolean Searching(int [] Num , int x , int y , int z){
       if(y==0 || x == y)
           return false;
       if (Num [x] == z)
           return true;
       return Searching(Num , x+1 , y , z);
   }
}
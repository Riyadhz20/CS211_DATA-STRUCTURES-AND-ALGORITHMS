package lab3.challengdr;

import java.util.Scanner;

public class Lab3ChallengDR {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.println("Enter 10 integers Number only: ");
        
        int [] num = new int[10];
        for(int i = 0; i<num.length;i++){
            num[i] = read.nextInt();
        }
        
        int [] numRe = Re(num ,0,1);
        for(int i = 0; i<numRe.length;i++){
            System.out.print(numRe[i]+" ");
        }
    }
    public static int [] Re(int [] S,int i,int l){
        if(i == S.length){
            return S;
        }
        else{
            int t = 0;
            
            t = S[i];
            S[i]=S[l];
            S[l]=t;
            
        return Re(S, i+=2, l+=2);
        }
    }
}

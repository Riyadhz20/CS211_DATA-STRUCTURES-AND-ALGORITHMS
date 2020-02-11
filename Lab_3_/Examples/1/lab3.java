package lab3;

import java.util.Scanner;

/**
 *
 * @author Riyad
 */
public class Lab31 {

    public static void main(String[] args) {
        int base, exp;
        int answer;
        
        Scanner read = new Scanner(System.in);
        System.out.println("Use integers only.");
// get base
        System.out.print("Base: ");
        base = read.nextInt();

// get exponent
        System.out.print("Power: ");
        exp = read.nextInt();
        answer = power(base, exp);
        System.out.println(base + " raised to the " + exp + " is " + answer);
    }


    public static int power(int base, int exp) {
        int pow;
// if the exponent is 0, set pow to 1
// otherwise set pow to base*base^(exp-1)
        if (exp == 0)
            return 1;
        return base * power(base, --exp);
    }
}

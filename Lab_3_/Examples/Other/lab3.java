package lab3;


import java.util.Scanner;

public class Test {

    // Driven Program to check above 
    public static void main(String args[]) {
        // test digitSum method
	int num = 12345;
	int result = digitSum(num);
	System.out.println("Sum of digits in " + num + " is " + result);
	//test isPalindrome method
	System.out.println(isPalindrome("home"));
	System.out.println(isPalindrome("madam"));

	// test crazySum
	int N = 2;
	System.out.println(crazySum(N));

	   //test search method
        int arr[] = {1, 3, 5, 2, 3};
        int x = 2;
        //Method call to find x 
        boolean found = search(arr, x, 0);
        if (found) {
            System.out.println("Element " + x + " is present");
        } else {
            System.out.println("Element " + x + " is not present");
        }
	//test haveSubsetSum method
	int set[] = {3, 34, 4, 12, 5, 2};
	int sum = 9;
	int n = set.length;
	if (haveSubsetSum(set, n, sum) == true) {
	    System.out.println("Found a subset ");
	} else {
	    System.out.println("No subset");
	}

    }

    //Exercises 1
    static int digitSum(int n) {
	if (n == 0) {
	    return 0;
	}
	return (n % 10 + digitSum(n / 10));
    }

    //Exercises 2
    public static boolean isPalindrome(String s) {
	if (s.length() == 0 || s.length() == 1) {
	    return true;
	}
	if (s.charAt(0) == s.charAt(s.length() - 1)) /* check for first and last char of String:
             if they are same then  the same thing for a substring
            with first and last char removed. and carry on this
             until  string completes or condition fails*/ {
	    return isPalindrome(s.substring(1, s.length() - 1));
	}

	// if its not the case than string is not.
	return false;
    }
//Homework 1

    public static long crazySum(int n) {
	// 1^1 = 1 
	if (n == 1) {
	    return 1;
	} else // Recursive call 
	{
	    return ((long) power(n, n) + crazySum(n - 1));
	}
    }
    //Homework 2

     public static boolean search(int list[], int value, int startIndex) {
        if (list[startIndex] == value) // one base case 
        {
            return true;
        } else if (startIndex == list.length - 1) // another base case
        {
            return false;
        } else // general case 
        {
            return search(list, value, startIndex + 1);
        }
    }

//Challenge Question

    static boolean haveSubsetSum(int subset[], int n, int target) {
	// Base Cases 
	if (target == 0) {
	    return true;
	}
	if (n == 0 && target != 0) {
	    return false;
	}

	// If last element is greater than 
	// target, then ignore it 
	if (subset[n - 1] > target) {
	    return haveSubsetSum(subset, n - 1, target);
	}

	/* else, check if sum can be obtained  
        by any of the following 
            (a) including the last element 
            (b) excluding the last element */
	return haveSubsetSum(subset, n - 1, target) || haveSubsetSum(subset, n - 1, target - subset[n - 1]);
    }

    public static int power(int base, int exp) {
	int pow;
// if the exponent is 0, set pow to 1
// otherwise set pow to base*base^(exp-1)
	if (exp == 0) {
	    return 1;
	}
	return base * power(base, --exp);
    }
}

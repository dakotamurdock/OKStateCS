/*
Write a program that asks the user for a positive inteer, n, and then calculates a new value for n based on whether it
is odd or even:

if n is even, the new n is n/2

if n is odd, the new n is 3 * n + 1
 */

import java.util.Scanner;

public class Murdock_Problem19 {
    public static void main(String[] args) {

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a positive integer:");
        userInput = scnr.nextInt();

        //While we haven't reached 1, we will perform the operations as specified in the problem statement
        int currentNum = userInput;
        while(currentNum != 1){
            System.out.println(currentNum);
            if(currentNum % 2 == 0){
                //This is an even number
                currentNum = currentNum / 2;
            }
            else{
                //This is an odd number
                currentNum = 3 * currentNum + 1;
            }
        }

        System.out.println(currentNum);
    }
}

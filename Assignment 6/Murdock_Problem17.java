/*
Prompt the user for a number, n. Print the sum of all numbers from 1 to n which are divisible by 3 or 5.
 */

import java.util.Scanner;

public class Murdock_Problem17 {
    public static void main(String[] args) {

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will provide the sum of all numbers from 1 to n divisble " +
                "by 3 or 5.");
        System.out.println("Input a positive integer:");
        userInput = scnr.nextInt();

        //Creating an array to store numbers that are divisible by 3 or 5
        int divisibleNumbers[] = new int[userInput];
        int arrayPosition = 0;

        //Loop through each number from 1 to user input and check if the remainder of division w/ 3 or 5 is 0
        for(int i = 1; i <= userInput; ++i){
            if(i % 3 == 0){
                divisibleNumbers[arrayPosition] = i; //Adding to array
                ++arrayPosition;
            }
            else if(i % 5 == 0){
                divisibleNumbers[arrayPosition] = i; //Adding to array
                ++arrayPosition;
            }
        }

        //Loop through numbers in array that were divisible and add them up
        int sum = 0;
        for(int i = 0; i < divisibleNumbers.length; ++i){
            sum = sum + divisibleNumbers[i];
        }

        //Print the results
        System.out.println("The sum is " + sum);
    }
}

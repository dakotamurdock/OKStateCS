/*
Prompt the user for a number n. Generate all palindrome numbers from 10 to n.
 */

import java.util.Scanner;

public class Murdock_Problem6 {
    public static void main(String[] args){

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will generate all palindrome numbers from 10 to n.");
        System.out.println("Input an integer:");
        userInput = scnr.nextInt();

        //Creating an array to store numbers that pop positive for being a palindrome number
        int palindromeNumbers[] = new int[userInput];
        int arrayPosition = 0;

        //Variables used to check palindrome number status in below loops
        int length;
        String reverseCurrentNum;
        String currentNumString;

        //Loop from 10 to user input checking if each number meets criteria for being a palindrome number
        for(int i=10; i <= userInput; ++i) {
            reverseCurrentNum = ""; //resetting string value from last iteration of loop
            currentNumString = Integer.toString(i); //Convert from int to string for easier individual digit access
            length = currentNumString.length();

            //Loop through user input number positions and create the reverse of it
            for (int j = (length - 1); j >= 0; --j) {
                reverseCurrentNum = reverseCurrentNum + Character.toString(currentNumString.charAt(j));
            }

            //Check if the reverse is the same as the input in their string format and add the int value to the array
            if (reverseCurrentNum.compareTo(currentNumString) == 0) {
                palindromeNumbers[arrayPosition] = i;
                ++arrayPosition;
            }
        }

        //Printing out values in the array
        for(int i=0; i < arrayPosition; ++i){
            System.out.print(palindromeNumbers[i] + " ");
        }

    }
}


/*
Prompt the user for a number, n. Print the sum of all Armstrong numbers from 0 to n.
 */

import java.util.Scanner;

public class Murdock_Problem14 {
    public static void main(String[] args) {

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will sum all Armstrong numbers from 0 to n.");
        System.out.println("Input an integer:");
        userInput = scnr.nextInt();

        int armstrongNumbers[] = new int[userInput];

        //Variables used to check Armstrong number status in below loops
        int length;
        int sum = 0;
        int num;
        int arrayPosition = 0;
        String currentNumString;

        //Loop from 0 to user input checking if each number meets criteria for being an Armstrong number
        for(int i=0; i <= userInput; ++i){
            currentNumString = Integer.toString(i); //Making the number a string makes it easier to access each digit
            length = currentNumString.length(); //Getting length of number, i.e. 1 digit, 2 digits, 3 digits, etc.
            sum = 0;

            //Loop through string of user input taking each digit, cubing it, and adding to the running sum
            for(int j=0; j < length; ++j){
                num = Character.getNumericValue(currentNumString.charAt(j));
                sum = sum + (num * num * num);
            }

            //Checking if the running sum equals the input and adding to array
            if(sum == i){
                armstrongNumbers[arrayPosition] = i;
                ++arrayPosition;
            }
        }

        //Loop through array of Armstrong numbers and add them all together
        int armstrongSum = 0;
        for(int i=0; i < arrayPosition; ++i){
            armstrongSum = armstrongNumbers[i] + armstrongSum;
        }

        //Printing the results
        System.out.println("The sum of the Armstrong numbers in this range is: " + armstrongSum);
    }
}

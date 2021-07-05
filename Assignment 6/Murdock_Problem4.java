/*
Prompt the user for a number n. Check if the number is an Armstrong number i.e. the sum of the cube of individual
digits returns the same number.
*/

import java.util.Scanner;

public class Murdock_Problem4 {
    public static void main(String[] args){

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will check if it is an Armstrong number.");
        System.out.println("Input an integer:");
        userInput = scnr.nextInt();

        //Convert user input to string to manipulate number positions easier and get length of number for later loop
        String userInputString;
        int length;
        userInputString = Integer.toString(userInput);
        length = userInputString.length();

        int sum = 0;
        int num; //This is used for the individual digits in the number

        //Loop through string of user input taking each digit, cubing it, and adding to the running sum
        for(int i=0; i < length; ++i){
            num = Character.getNumericValue(userInputString.charAt(i));
            sum = sum + (num * num * num);
        }

        //Checking if the running sum equals the input and printing result
        if(sum == userInput){
            System.out.println("This is an Armstrong number.");
        }
        else{
            System.out.println("This is not an Armstrong number...");
        }
    }
}

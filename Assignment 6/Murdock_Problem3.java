//Prompt the user for a number n. Check if the number is a palindrome i.e. when reversed, the number stays the same.

import java.util.Scanner;

public class Murdock_Problem3 {
    public static void main(String[] args){

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will check if it is an palindrome number.");
        System.out.println("Input an integer:");
        userInput = scnr.nextInt();

        //Convert user input to string to manipulate number positions easier and get length of number for later loop
        String userInputString;
        int length;
        userInputString = Integer.toString(userInput);
        length = userInputString.length();

        //Creating a second string to create the backwards number
        String reverseUserInput = "";

        //Loop through user input number positions and create the reverse of it
        for(int i=(length - 1); i >= 0; --i){
            reverseUserInput = reverseUserInput + Character.toString(userInputString.charAt(i));
        }

        //Check if the reverse is the same as the input in their string format and print results
        if(reverseUserInput.compareTo(userInputString) == 0){
            System.out.println("This number is a palindrome!");
        }
        else{
            System.out.println("This number is not a palindrome...");
        }

    }
}

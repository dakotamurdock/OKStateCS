//Prompt the user for a number n. Find the reverse of the given number n. Example: n=897. Output: 798.

import java.util.Scanner;

public class Murdock_Problem2 {
    public static void main(String[] args){

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Get user input
        int userInput;
        System.out.println("Input a number, n. This program will display the reverse of n.");
        System.out.println("Input an integer:");
        userInput = scnr.nextInt();

        //Convert user input to string to manipulate number positions easier and get length of number for later loop
        String userInputString;
        int length;
        userInputString = Integer.toString(userInput);
        length = userInputString.length();

        //Loop through string of user input and print in reverse order
        for(int i=(length - 1); i >= 0; --i){
            System.out.print(userInputString.charAt(i));
        }

    }
}

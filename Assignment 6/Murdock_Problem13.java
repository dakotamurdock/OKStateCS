/*
Prompt the user for a number n. Check if the number is binary or not i.e. all digits in the number must be either
0 or 1.
 */

import java.util.Scanner;

public class Murdock_Problem13 {
    public static void main(String[] args) {

        //Create scanner object
        Scanner scnr = new Scanner(System.in);

        //Variables for checking if binary in later loop
        String userInput;
        char checkChar;
        boolean isBinary = true;
        int length;

        //Get user input
        System.out.println("Input a number, n. This program will determine if it is a binary number or not.");
        System.out.println("Input a number: ");
        userInput = scnr.nextLine(); //Using next line because if spaces are used in binary num, need to pick it all up
        length = userInput.length();

        //Loop through string checking that each character is a 0, 1, or space (in case user broke up binary sequence into 4s)
        for(int i = 0; i < length; ){
            checkChar = userInput.charAt(i);
            if((Character.compare(checkChar, '0') == 0) || (Character.compare(checkChar, '1') == 0) || (Character.compare(checkChar, ' ') == 0)){
                ++i;
            }

            //We can end loop early if we find a single character that is not a 0, 1, or space
            else{
                isBinary = false;
                break;
            }
        }

        //Print the results
        if(isBinary == true){
            System.out.println("This is a binary number.");
        }
        else{
            System.out.println("This is not a binary number.");
        }


    }
}

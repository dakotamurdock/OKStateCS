import java.util.Scanner;
public class Murdock_Problem2 {

    /*
    Problem Statement:
    Prompt the user for a number n. Check if the number is a valid binary number or not i.e. all digits in the number
    must be either 0 or 1. For example, 101 is a binary number whereas 123 is not. Note: 0 and 1 are the only single
    digit binary numbers
    */

    /*
    Solution:
    I bring in the user input as a string which allows me to use character methods to check if they are 0s, 1s, or
    spaces. I chose to include spaces in case the user inputs a binary number in 4-character sections (i.e. 0011 1010).
    If any character is found to be something else, it sets a boolean variable to false which triggers the print
    statement for non-binary numbers.
     */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String userInput;
        char checkChar;
        boolean isBinary = true;
        int userInputLength;

        //Get user input
        System.out.println("Give me a number, and I'll tell you if it is a binary number or not.");
        System.out.println("Input a number:");
        userInput = scnr.nextLine();

        //Determine length of string for later for loop
        userInputLength = userInput.length();

        //Loop through string checking that each character is a 0, 1, or space (in case user broke up binary sequence into 4s)
        for(int i = 0; i < userInputLength; ){
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

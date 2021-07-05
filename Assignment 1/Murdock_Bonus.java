import java.util.Scanner;
public class Murdock_Bonus {

    /*
    Problem Statement:
    Password checker program basically checks if the password is valid or not based on password policies mention below:
        a. Password should not contain any space.
        b. Password should contain at least one digit (0-9) and no consecutive digits.
        c. Password length should be between 6 to 8 characters.
        d. Password should contain at least one uppercase letter(A-Z).
        e. Password should contain no special character (@, #, %, &, $, etc….).
    */

    /*
    Solution:
    I store user input as a string and loop through each character and count spaces, uppercase letters, digits, and
    special characters using ASCII numbers. I also check length of input. Based on those results I set Boolean values
    to false if they don’t meet requirements. I print out results based on Boolean values.
     */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String userInput;
        char checkChar;
        int userInputLength;
        int spaceCounter = 0;
        int digitCounter = 0;
        int specCharCounter = 0;
        int upperCaseCounter = 0;
        boolean consecDigits = false;
        boolean reqA = true;
        boolean reqB = true;
        boolean reqC = true;
        boolean reqD = true;
        boolean reqE = true;

        //Print out requirements for user and get their input
        System.out.println("Password Requirements:");
        System.out.println("a. Password should not contain any spaces.");
        System.out.println("b. Password should contain at least one digit (0-9) and no consecutive digits.");
        System.out.println("c. Password length should be between 6 to 8 characters.");
        System.out.println("d. Password should contain at least one uppercase letter(A-Z).");
        System.out.println("e. Password should contain no special character (@, #, %, &, $, etc….).");
        System.out.println("Please create your password:");
        userInput = scnr.nextLine();

        //Get input length for later for loop and to declare an array for requirement b.
        userInputLength = userInput.length();
        int[] userInputDigitsArray = new int[userInputLength];

        //i for loop to go through each character from their input to check the various requirements
        for(int i=0; i < userInputLength; ++i){
            checkChar = userInput.charAt(i);
            //Password requirement a.
            if(checkChar == 32){
                ++spaceCounter;
            }

            //Password requirement b.
            if(checkChar > 64 && checkChar < 91) {
                ++upperCaseCounter;
            }

            //Password requirement d.
            if(checkChar > 47 && checkChar < 58){
                userInputDigitsArray[i] = 1;
                if(i > 0) {
                    if (userInputDigitsArray[i - 1] == 1) {
                        consecDigits = true;
                    }
                }
                ++digitCounter;
            }
            else{
                userInputDigitsArray[i] = 0;
            }

            //Password requirement e.
            if((checkChar > 32 && checkChar < 48) || (checkChar > 57 && checkChar < 64) || (checkChar > 90 && checkChar < 97) || (checkChar > 122 && checkChar < 127)){
                ++specCharCounter;
            }
        }

        //Password requirement a.
        if(spaceCounter > 0){
            reqA = false;
        }

        //Password requirement b.
        if((digitCounter == 0) || (consecDigits == true)){
            reqB = false;
        }

        //Password requirement c.
        if(userInputLength < 6 || userInputLength > 8){
            reqC = false;
        }

        //Password requirement d.
        if(upperCaseCounter == 0){
            reqD = false;
        }

        //Password requirement e.
        if(specCharCounter > 0){
            reqE = false;
        }

        //Print errors
        if(reqA == false){
            System.out.println("Error: Your password contains a space.");
            System.out.println("a. Password should not contain any spaces.");
        }

        if(reqB == false){
            System.out.println("Error: Your password must contain a number, but no consecutive digits.");
            System.out.println("b. Password should contain at least one digit (0-9) and no consecutive digits.");
        }

        if(reqC == false){
            System.out.println("Error: Your password does not meet the length requirement.");
            System.out.println("c. Password length should be between 6 to 8 characters.");
        }

        if(reqD == false){
            System.out.println("Error: Your password must contain at least one uppercase letter.");
            System.out.println("d. Password should contain at least one uppercase letter(A-Z).");
        }

        if(reqE == false){
            System.out.println("Error: Your password contained a special character.");
            System.out.println("e. Password should contain no special character (@, #, %, &, $, etc….).");
        }

        //Confirm good password
        if(reqA == true && reqB == true && reqC == true && reqD == true && reqE == true){
            System.out.println("Your password met all requirements.");
        }
    }

}

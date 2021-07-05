import java.util.Scanner;
public class Murdock_Problem2 {
    /*
    Problem Statement:
    Write a program so that the numbers in the array appear in reversed order without creating a new array.
    You will need to use a temporary variable to do this.
    */

    /*
    Solution:
    I take user input of array size to create and fill a 1D array, then I loop through the array to print out the user
    input. I use a for-loop utilizing a temporary value to swap the values in the array around. Finally, I have one last
    loop to print the values of the newly rearranged array.
    */

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("How many total elements will you have in the array? Type an integer:");
        int size = scnr.nextInt();
        int maxIndex = size - 1;
        int[] userInput = new int[size];
        System.out.println("List the elements for your array. Type each element followed by enter.");
        for(int i=0; i < size; ++i){
            userInput[i] = scnr.nextInt();
        }

        //Printing user input
        System.out.print("Your input array: [");
        for(int i=0; i < size; ++i){
            if(i < maxIndex) {
                System.out.print(userInput[i] + ", ");
            }
            else{
                System.out.print(userInput[i]);
            }
        }
        System.out.println("]");

        //Nested for-loop to do position swaps
        int tempVal;
        for (int i = 0; i < (size / 2); ++i) {
                tempVal = userInput[i];
                userInput[i] = userInput[maxIndex - i];
                userInput[maxIndex - i] = tempVal;
        }

        //Loop to print values of the rearranged array in matrix format
        System.out.print("This array reversed is: [");
        for(int i=0; i < size; ++i){
            if(i < maxIndex) {
                System.out.print(userInput[i] + ", ");
            }
            else{
                System.out.print(userInput[i]);
            }
        }
        System.out.println("]");
    }
}

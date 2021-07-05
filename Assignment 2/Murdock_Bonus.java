import java.util.Scanner;
public class Murdock_Bonus {
    /*
    Problem Statement:
    Given a 2D array A, your task is to convert all the rows to columns and columns to rows.
    */

    /*
    Solution:
    First, I take user inputs for rows and cols to set up perfect sized array and then take user input for array elements
    and fill array. I use a user defined method to print both user input matrix and the transposed matrix rather than
    having two for-loops for improved code readability. I use a nested for-loop and temporary variable for the actual
    position swaps.
    */

    //User defined method used for printing any size/shape matrix passed to it
    public static void printMatrix(int[][] userInput, int rows, int cols){
        int maxRowIndex = rows - 1;
        int maxColsIndex = cols - 1;

        for(int i=0; i < rows; ++i){
            for(int j=0; j < cols; ++j){
                if((j == 0) && (i == 0)){
                    System.out.print("{");
                    System.out.print("[");
                    System.out.print(userInput[i][j] + ", ");
                }
                else if(j == 0){
                    System.out.print("[");
                    System.out.print(userInput[i][j] + ", ");
                }
                else if(j == maxColsIndex){
                    System.out.print(userInput[i][j]);
                    System.out.print("]");
                }
                else{
                    System.out.print(userInput[i][j] + ", ");
                }

                if((j == maxColsIndex) && (i == maxRowIndex)){
                    System.out.print("}");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);

        //Take user input for array size and shape
        System.out.println("How many rows are in your array? Type an integer:");
        int rows = scnr.nextInt();
        System.out.println("How many columns are in your array? Type an integer:");
        int cols = scnr.nextInt();
        int[][] userInput = new int[rows][cols];
        System.out.println("List the elements for your array. Type each element followed by enter.");
        for(int i=0; i < rows; ++i){
            for(int j=0; j < cols; ++j) {
                userInput[i][j] = scnr.nextInt();
            }
        }

        //Print user input with if-statements for formatting as an array
        System.out.println("Your input matrix:");
        printMatrix(userInput, rows, cols);

        //Swap values nested for-loop with breaks included to end the swapping loops at the right time (otherwise will re-swap back to original array)
        int tempVal;
        for (int i = 0; i < rows; ++i) {
            for (int j = i; j < cols; ++j) {
                tempVal = userInput[i][j];
                userInput[i][j] = userInput[j][i];
                userInput[j][i] = tempVal;
            }
        }

        //Loop to print values of the rearranged array in matrix format
        System.out.println("");
        System.out.println("Your matrix transposed:");
        printMatrix(userInput, rows, cols);

    }
}

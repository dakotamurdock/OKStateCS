import java.util.Scanner;
public class Murdock_Problem3 {
    /*
    Problem Statement:
    Write a Java program to find the second largest and smallest element in an array. You should be able to handle both
    single and multidimensional arrays.
    */

    /*
    Solution:
    First, I take user inputs for rows and cols to set up perfect sized array and then take user input for array elements
    and fill array. Then I print out array with matrix formatting using if-statements to format correctly. Then I loop
    through the user input array and all of the elements from the input array into a 1D array for sorting. I sort it by
    value with a for-loop and temporary variable. Then I print results using array positional access from the sorted array.
    */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //Take user input for array size and shape
        System.out.println("How many rows are in your array? Type an integer:");
        int rows = scnr.nextInt();
        int maxRowIndex = rows - 1;
        System.out.println("How many columns are in your array? Type an integer:");
        int cols = scnr.nextInt();
        int maxColsIndex = cols - 1;
        int numElements = rows * cols;
        int[][] userInput = new int[rows][cols];
        System.out.println("List the elements for your array. Type each element followed by enter.");
        for(int i=0; i < rows; ++i){
            for(int j=0; j < cols; ++j) {
                userInput[i][j] = scnr.nextInt();
            }
        }

        //Print user input with if-statements for formatting as an array
        System.out.println("Your input matrix:");
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

        //Creating a 1D array to put contents of any specified array to make it easier to sort by values
        int[] sortedArray = new int[numElements];

        //Nested for-loop to go through each position in any size/shape array and put it into the single dimensional array
        int k = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                sortedArray[k] = userInput[i][j];
                ++k;
            }
        }

        //Nested for-loop to sort elements in 1D array by value
        int tempVal;
        for (int i = 0; i < numElements; ++i) {
            for (int j = 0; j < numElements; ++j) {
                if (sortedArray[i] < sortedArray[j]) {
                    tempVal = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = tempVal;
                }
            }
        }

        //Printing out the second largest and second smallest elements
        System.out.println("");
        System.out.println("Your Second Smallest Element: " + sortedArray[1]);
        System.out.println("Your Second Largest Element: " + sortedArray[numElements - 2]);
    }
}

public class Murdock_Problem1 {
    /*
    Problem Statement:
    Write a Java program to perform Matrix addition. You can hardcode/declare your matrix in the program itself.
    */

    /*
    Solution:
    I hardcoded the matrix from the example and then chose to use a user defined method to do the calculation. I used
    nested for-loops to be able to flexibly do the calculation regardless of array size. To show the results I print
    the results of each calculation in an array-like format.
    */

    //Method defined to do the matrix addition
    public static void matrixAddition(int[][] leftMatrix, int[][] rightMatrix, int[][] sumMatrix){

        //Nested for-loop to do the calculation and print results in matrix format
        for(int i=0; i < leftMatrix.length; i++) {
            for (int j = 0; j < leftMatrix[0].length; j++) {
                sumMatrix[i][j] = leftMatrix[i][j] + rightMatrix[i][j];
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        //Declaring matrices for the addition. Feel free to change this to any shape or size array, as long as the L & R arrays are the same size/shape!
        int[][] leftMatrix = {{3, 4}, {2, 1}};
        int[][] rightMatrix = {{1, 5}, {3, 7}};

        //Determining the size/shape of the arrays put in
        int rows = leftMatrix.length;
        int cols = leftMatrix[0].length;

        //Creating a new array of appropriate shape/size to hold the result of the addition
        int[][] sumMatrix = new int[rows][cols];

        //Calling the method to perform the calculation
        matrixAddition(leftMatrix, rightMatrix, sumMatrix);
    }
}

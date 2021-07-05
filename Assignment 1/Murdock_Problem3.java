import java.util.Scanner;
public class Murdock_Problem3 {

    /*
    Problem Statement:
    Write a JAVA program that generates the list of prime numbers between two given numbers.
    */

    /*
    Solution:
    I bring in the user inputs and store them as lower and upper bounds. I create an oversized array to hold prime
    numbers and fill with 2 and 3 to start. I perform mod operator on every number from 4 to upperbound with each prime
    number stored in the array so far and store it in the array if it is prime. I print all prime numbers in the array
    between the range given by the user.
     */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input1;
        int input2;
        int lowerBound;
        int upperBound;
        boolean isPrime = false;

        //Get user input
        System.out.println("Give me 2 numbers, and I'll tell you the prime numbers between them.");
        System.out.println("Input 2 integers separated by a space, then press Enter: ");
        input1 = scnr.nextInt(); //Get first user input
        input2 = scnr.nextInt(); //Get second user input

        //Putting values in right order in case user put the larger number in first
        if(input1 > input2){
            lowerBound = input2;
            upperBound = input1;
        }
        else{
            lowerBound = input1;
            upperBound = input2;
        }

        //Making an oversized array to store all of the numbers we determine to be prime
        int[] primeList = new int[upperBound];

        //Filling the first two prime numbers in to make everything easier
        primeList[0]=2;
        primeList[1]=3;
        //Initializing variable k at next available slot for prime numbers in the array for later loop
        int k = 2;

        //i for loop to go through all possible numbers that could be prime (from 4 because we already determined 2 and 3 were prime)
        for(int i=4; i < upperBound; ++i){

            //j for loop used to go back through prime list that has been populated so far
            for(int j=0; j < k; ++j) {

                //if there is a remainder with previously determined prime numbers then it isn't divisible by that number making it possibly prime
                if (i % primeList[j] != 0) {
                    isPrime = true;
                } else {
                    isPrime = false;
                    break;
                }

            }

                //If it made it through all previous prime number division checks and isPrime is still true, then it is a prime number
                if(isPrime == true){
                    primeList[k] = i;
                    ++k;
                }
        }

        //Printing out prime list that falls between upper and lower user bounds
        System.out.println("The prime numbers between " + lowerBound + " and " + upperBound + " are:");
        for(int i=0; i < upperBound; ++i){
            if(primeList[i] > lowerBound){
                System.out.print(primeList[i] + " ");
            }
        }

    }
}

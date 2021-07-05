import java.util.Scanner;
public class Murdock_Problem1 {

    /*
    Problem Statement:
    Write a program which will ask the user to input an integer number corresponding to a duration expressed in
    minutes. You will then display on the screen the conversion of this duration in the hours:minutes format.
    */

    /*
    Solution:
    This problem was very straightforward. I take in an integer input from the user representing minutes, I use integer
    division to get the number of hours, I use modulo to get the remainder which is the number of minutes left after the
    hours have been determined, and I print it out formatted with a colon.
     */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int minutesInput;
        int hours;
        int minutes;

        //Get user input
        System.out.println("Type an integer value of minutes for conversion to HH:MM format:");
        minutesInput = scnr.nextInt();

        //Integer division to determine hours
        hours = minutesInput / 60;
        //Modulo gives the remainder which is the minutes
        minutes = minutesInput % 60;

        System.out.println("HH:MM format: " + hours + ":" + minutes);

    }
}

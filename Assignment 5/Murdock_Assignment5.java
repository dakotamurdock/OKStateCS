import java.io.*;
import java.util.*;

/*
I created the ReviewEntry class with the 3 specified variables, and I created an instance of the class 8544 times and
stored them in an array. I used a buffered reader to bring in the .tsv file, and then with the readline method I go
line by line and split the columns up by tab storing each column as a string in an array. I check each line to see if
the sentence ID is the same as the previous and update the phrase count and sum sentiment score. At the end I get user
input for which sentence they want to evaluate which calls the calculation for computing the avg sentiment, determining
if it is pos/neut/neg sentiment, and print the results.
 */

public class Murdock_Assignment5 {
    public static void main(String[] args){

        String line = "";
        int i = 1;
        ReviewEntry[] sentenceArray = new ReviewEntry[8545];

        //Create instances of the ReviewEntry class for each sentence in the file
        for(int j = 0; j <= 8544; ++j){
            sentenceArray[j] = new ReviewEntry(j, 0, 0);
        }

        //Use buffered reader to bring in the file
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/dakotamurdock/Desktop/Programming Items/CS2133 Assignments/" +
                            "Assignment 5/movieReviews.tsv"));
            //Read in each line
            while((line = br.readLine()) != null){
                //Separate line into 4 columns by TAB separator
                String[] phraseArray = line.split("\t");
                try {
                    //Determine if sentence ID is for the same sentence as before or for a new one and update counts
                    if (Integer.parseInt(phraseArray[1]) == i) {
                        sentenceArray[i].setNumPhrases(sentenceArray[i].getNumPhrases() + 1);
                        sentenceArray[i].setTotalPhraseScore(sentenceArray[i].getTotalPhraseScore() +
                                Integer.parseInt(phraseArray[3]));
                    } else {
                        i = Integer.parseInt(phraseArray[1]);
                        sentenceArray[i].setNumPhrases(sentenceArray[i].getNumPhrases() + 1);
                        sentenceArray[i].setTotalPhraseScore(sentenceArray[i].getTotalPhraseScore() +
                                Integer.parseInt(phraseArray[3]));
                    }
                }
                catch(NumberFormatException e){

                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a sentence ID: ");
        //Take user input of which sentence they want to evaluate
        int userInput = 0;
        while(userInput == 0) {
            //Try-catch block to ensure the proper type is put in
            try {
                userInput = scnr.nextInt();
                System.out.println("Sentence ID " + userInput + sentenceArray[userInput].averageSentiment());
            } catch (InputMismatchException e) {
                System.out.println("You didn't enter a proper sentence ID. Try again.");
                System.out.println("Enter a sentence ID: ");
                scnr.nextLine();
            }
        }
    }
}

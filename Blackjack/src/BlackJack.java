import java.util.Arrays;
import java.util.Scanner;
public class BlackJack {

    //Method to take random card number generated in main and assign it with a suit and card number for later display
    public static String cardDisplay(int cardNum) {
        int i; //For loop variable

        //Filling array of card deck suits (spades, hearts, diamonds, clubs)
        String[] deckSuits = new String[52];

        for (i = 0; i < 52; ++i) {
            if (i < 13) {
                deckSuits[i] = "S";
            } else if (i < 26) {
                deckSuits[i] = "H";
            } else if (i < 39) {
                deckSuits[i] = "D";
            } else {
                deckSuits[i] = "C";
            }
        }

        //Filling array with card number (i.e. 2, 3, 4..., J, Q, K, A)
        String[] deckNum = new String[52];

        for (i = 0; i < 4; ++i) {
            deckNum[0 + (i * 13)] = " " + 2;
            deckNum[1 + (i * 13)] = " " + 3;
            deckNum[2 + (i * 13)] = " " + 4;
            deckNum[3 + (i * 13)] = " " + 5;
            deckNum[4 + (i * 13)] = " " + 6;
            deckNum[5 + (i * 13)] = " " + 7;
            deckNum[6 + (i * 13)] = " " + 8;
            deckNum[7 + (i * 13)] = " " + 9;
            deckNum[8 + (i * 13)] = "" + 10;
            deckNum[9 + (i * 13)] = " J";
            deckNum[10 + (i * 13)] = " Q";
            deckNum[11 + (i * 13)] = " K";
            deckNum[12 + (i * 13)] = " A";
        }

        return deckNum[cardNum] + deckSuits[cardNum];

    }

    //Method to assign random card from main with a corresponding value
    public static int cardValue(int cardNum) {
        int i; //for looping variable

        //Filling array with card value
        int[] deckVal = new int[52];

        for (i = 0; i < 4; ++i) {
            deckVal[0 + (i * 13)] = 2;
            deckVal[1 + (i * 13)] = 3;
            deckVal[2 + (i * 13)] = 4;
            deckVal[3 + (i * 13)] = 5;
            deckVal[4 + (i * 13)] = 6;
            deckVal[5 + (i * 13)] = 7;
            deckVal[6 + (i * 13)] = 8;
            deckVal[7 + (i * 13)] = 9;
            deckVal[8 + (i * 13)] = 10;
            deckVal[9 + (i * 13)] = 10;
            deckVal[10 + (i * 13)] = 10;
            deckVal[11 + (i * 13)] = 10;
            deckVal[12 + (i * 13)] = 11;
        }

        return deckVal[cardNum];
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //Declaring variables
        char newGameResponse; //Variable used to determine if user wants to play or not, will hold a Y/N response
        char hitStand; //Variable used to determine if user wants to add a card or keep what they have
        char doubleDown; //Variable used to determine if user wants to double down

        //Variable to hold and display the first card's value in the dealers hand
        String dealerCard1;
        String dealerCard2;

        //Variables to hold and display the first card's value in player's hands
        String p1Card1;
        String p1Card2;

        //Variable to skip scoring after hitting loops if game ended in first dealing
        boolean firstHand = false;

        //for looping variables
        int i;
        int j;
        int x;

        //Variable to hold total value of each player's hands
        int dTotal = 0;
        int p1Total = 0;

        //Variables to handle the betting aspect of the game
        double p1Wager;
        double p1Money;

        //Array to hold all of the cards that will be drawn for each player. 14 hits maximum
        //int drawnCards[][] = new int[14][2];

        //Asks if user wants to play another hand
        System.out.println("New Game? (Yes = Y, No = N)");
        newGameResponse = scnr.next().charAt(0);

        //Start with the betting aspect of the game
        System.out.println("How much money do you have?");
        System.out.print("$");
        p1Money = scnr.nextDouble(); //User inputs their total amount of money they are playing with

        //Based on playing another hand response being yes, this will continue to print new game
        while (newGameResponse == 89 || newGameResponse == 121) {

            //Start with the betting aspect of the game
            System.out.println("");
            System.out.print("Your Total Money: $"); //Display updated total money
            System.out.printf("%5.2f%n", p1Money);
            System.out.println("");

            System.out.println("Place your bets...");
            System.out.print("$");
            p1Wager = scnr.nextDouble(); //User inputs how much of their total money they will bet for that hand

            //While loop to ensure their bet doesn't exceed their total money
            while (p1Wager > p1Money) {
                System.out.println("You're too poor for that...try again...");
                p1Wager = scnr.nextDouble();
            }

            //Take the bet money out of the total money as long as they have enough
            p1Money = p1Money - p1Wager;

            //Array to hold sequence of cards for players
            int drawnCards[][] = new int[14][2];

            //Array to determine if ace score adjustment has been made with that ace when calculating total scores
            boolean aceUsed[][] = new boolean[14][2];

            //Nested for-loops will assign each of the players their cards
            for (i = 0; i < 2; ++i) {
                for (j = 0; j < 14; ++j) {
                    drawnCards[j][i] = (int) (Math.random() * ((51 - 1) + 1)) + 1;
                    aceUsed[j][i] = false; //Initially set aceUsed to default value of false
                }
            }

            //Takes the drawn card numbers from above and calls cardDisplay method to assign it with corresponding suit and card number
            dealerCard1 = cardDisplay(drawnCards[0][0]);
            dealerCard2 = cardDisplay(drawnCards[1][0]);
            p1Card1 = cardDisplay(drawnCards[0][1]);
            p1Card2 = cardDisplay(drawnCards[1][1]);

            //Takes the drawn card numbers from above and calls cardValue to add up what the cards are worth in the user's hand
            p1Total = cardValue(drawnCards[0][1]) + cardValue(drawnCards[1][1]); //add up card values
            dTotal = cardValue(drawnCards[0][0]) + cardValue(drawnCards[1][0]);

            //Print out the graphic for the player's cards. Note the first dealer card is hidden from user's view
            System.out.println((char)27 + "[35m");
            System.out.println("");
            System.out.println("Dealer Cards:");
            System.out.println(" _____   _____");
            System.out.println("|  xx | | " + dealerCard2 + " |");
            System.out.println("|     | |     |");
            System.out.println(" _____   _____");
            System.out.println("");
            System.out.println((char)27 + "[34m");
            System.out.println("");
            System.out.println("Player 1 Cards:");
            System.out.println(" _____   _____ ");
            System.out.println("| " + p1Card1 + " | | " + p1Card2 + " |");
            System.out.println("|     | |     |");
            System.out.println(" _____   _____ ");
            System.out.println("");

            //Check if dealer has blackjack. If so, end hand.
            if (dTotal == 21 && p1Total != 21) {
                System.out.println((char)27 + "[35m");
                System.out.println("");
                System.out.println("Dealer Cards:");
                System.out.println(" _____   _____");
                System.out.println("| " + dealerCard1 + " | | " + dealerCard2 + " |");
                System.out.println("|     | |     |");
                System.out.println(" _____   _____");
                System.out.println("");
                System.out.println("Dealer Total: " + dTotal);
                System.out.println("Pay up. Dealer has Blackjack.");
                System.out.println((char)27 + "[34m");
                System.out.print("Money left: $"); //Displays total money after losing to dealer's blackjack
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
                firstHand = true;
            }

            //Check if user has blackjack. If so, end hand.
            else if (p1Total == 21 && dTotal != 21) {
                System.out.println((char)27 + "[34m");
                System.out.println("Total: " + p1Total);
                System.out.println("BLACKJACK! YOU WIN!");
                System.out.println("You won $" + p1Wager * 1.5); //Display winnings for blackjack
                p1Wager = p1Wager * 2.5; //Calculate winnings
                p1Money = p1Money + p1Wager; //Add calculated winnings back to total money
                System.out.print("You now have $"); //Print new total money after winnings
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
                firstHand = true;
            }

            else if (p1Total == 21 && dTotal == 21) {
                System.out.println((char)27 + "[35m");
                System.out.println("");
                System.out.println("Dealer Cards:");
                System.out.println(" _____   _____");
                System.out.println("| " + dealerCard1 + " | | " + dealerCard2 + " |");
                System.out.println("|     | |     |");
                System.out.println(" _____   _____");
                System.out.println("");
                System.out.println("Dealer Total: " + dTotal);
                System.out.println("Wow, you have terrible luck. You got 21, but so did the dealer.");
                System.out.println("You pushed. You didn\'t lose... BUT YOU DIDN\'T WIN EITHER");
                p1Money = p1Money + p1Wager;
                System.out.println((char)27 + "[34m");
                System.out.println("You still have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
                firstHand = true;
            }

            //Handles being dealt 2 aces by reducing value of one of the aces
            else if (p1Total == 22) {
                p1Total = 12;
                System.out.println("Total: " + p1Total);
            }

            else {
                System.out.println("Total: " + p1Total);
            }

            //If dealer is dealt 2 aces
            if (dTotal == 22) {
                dTotal = 12;
            }

            //If hand didn't end on first deal, display option to hit or stay
            if (!firstHand) {
                System.out.println((char)27 + "[37m");
                if ((p1Money + p1Wager) >= (2 * p1Wager)) {
                    System.out.println("Hit/Stay? (Hit = h, Stay = s, Double Down = d)");
                    hitStand = scnr.next().charAt(0);
                }
                else {
                    System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                    //If user tries to double down when they don't have enough money
                    hitStand = scnr.next().charAt(0); //Get user input to hit or stay
                    while (hitStand == 68 || hitStand == 100) {
                        System.out.println("You don't have enough money to double down.");
                        System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                        hitStand = scnr.next().charAt(0); //Get user input to hit or stay
                    }
                }

                //Double wager if double down is selected
                if (hitStand == 68 || hitStand == 100) {
                    p1Money = p1Money - p1Wager;
                    p1Wager = p1Wager * 2;
                    System.out.println((char)27 + "[34m");
                    System.out.print("Your new wager totals: $");
                    System.out.printf("%5.2f%n", p1Wager);
                    System.out.println("");
                }

                //If user hits, new card is displayed and new total is calculated
                while (hitStand == 72 || hitStand == 104 || hitStand == 68 || hitStand == 100) {
                    int hitRoundCard = 3; //keeps track of how many times player has hit to assign next card from drawn cards array
                    for (i = hitRoundCard; p1Total < 21 && hitRoundCard < 15; ++i) {
                        if (hitRoundCard != 3 && (hitStand == 68 || hitStand == 100)){
                            break;
                        }
                        //System.out.println("");
                        System.out.println((char)27 + "[34m");
                        System.out.println(" _____");
                        System.out.println("| " + cardDisplay(drawnCards[i - 1][1]) + " |");
                        System.out.println("|     |");
                        System.out.println(" _____");
                        System.out.println("");
                        p1Total = p1Total + cardValue(drawnCards[i - 1][1]);
                        ++hitRoundCard;

                        //Note: still in the for-loop. Checking totals after each hit and responding appropriately

                        if (p1Total < 21) {
                            System.out.println((char)27 + "[34m");
                            System.out.println("Total: " + p1Total); //When less than 21, keep playing
                            System.out.println("");
                            if (hitStand == 68 || hitStand == 100) {
                                break;
                            }
                            System.out.println((char)27 + "[37m");
                            System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                            hitStand = scnr.next().charAt(0);
                            if (hitStand == 83 || hitStand == 115) {
                                break;
                            }
                        }

                        //If greater than 21 need to see if Aces were drawn and adjust totals to keep from improperly saying user busted
                        else if (p1Total > 21) {

                            //Was first drawn card an ace?
                            if (!aceUsed[0][1] && cardValue(drawnCards[0][1]) == 11) {
                                System.out.println((char)27 + "[34m");
                                p1Total = p1Total - 10;
                                System.out.println("Total: " + p1Total); //When less than 21, keep playing
                                System.out.println("");
                                if (hitStand == 68 || hitStand == 100) {
                                    break;
                                }
                                System.out.println((char)27 + "[37m");
                                System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                                hitStand = scnr.next().charAt(0);
                                aceUsed[0][1] = true;
                                if (hitStand == 83 || hitStand == 115) {
                                    break;
                                }
                            }

                            //Was second drawn card an ace?
                            else if (!aceUsed[1][1] && cardValue(drawnCards[1][1]) == 11) {
                                System.out.println((char)27 + "[34m");
                                p1Total = p1Total - 10;
                                System.out.println("Total: " + p1Total); //When less than 21, keep playing
                                System.out.println("");
                                if (hitStand == 68 || hitStand == 100) {
                                    break;
                                }
                                System.out.println((char)27 + "[37m");
                                System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                                hitStand = scnr.next().charAt(0);
                                aceUsed[1][1] = true;
                                if (hitStand == 83 || hitStand == 115) {
                                    break;
                                }
                            }

                            //Was most recent drawn card an ace?
                            else if (!aceUsed[i - 1][1] && cardValue(drawnCards[i - 1][1]) == 11) {
                                p1Total = p1Total - 10;
                                System.out.println((char)27 + "[34m");
                                System.out.println("Total: " + p1Total); //When less than 21, keep playing
                                System.out.println("");
                                if (hitStand == 68 || hitStand == 100) {
                                    break;
                                }
                                System.out.println((char)27 + "[37m");
                                System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                                hitStand = scnr.next().charAt(0);
                                aceUsed[i - 1][1] = true;
                                if (hitStand == 83 || hitStand == 115) {
                                    break;
                                }
                            }

                            //Were any of the other drawn cards an ace (basically if you've already hit more than once)
                            else {
                                for (x = 3; x < i; ++x) {
                                    if (!aceUsed[x - 1][1] && cardValue(drawnCards[x - 1][1]) == 11) {
                                        p1Total = p1Total - 10;
                                        System.out.println((char)27 + "[34m");
                                        System.out.println("Total: " + p1Total); //When less than 21, keep playing
                                        System.out.println("");
                                        if (hitStand == 68 || hitStand == 100) {
                                            break;
                                        }
                                        System.out.println((char)27 + "[37m");
                                        System.out.println("Hit/Stay? (Hit = h, Stay = s)");
                                        hitStand = scnr.next().charAt(0);
                                        aceUsed[x - 1][1] = true;
                                        if (hitStand == 83 || hitStand == 115) {
                                            break;
                                        }
                                    }
                                }
                            }

                            //System.out.println("Total: " + p1Total); //Print new total after each hit with ace adjustment

                            if (p1Total > 21) {
                                System.out.println((char)27 + "[31m");
                                System.out.println("");
                                System.out.println("Total: " + p1Total);
                                System.out.println("You busted. Idiot.");
                                System.out.println("");
                                //if after all of the possible adjustments for aces didn't help, user busted. End hit/stay option.
                                hitStand = 83;
                            }
                        }

                        if (p1Total == 21) {
                            System.out.println((char)27 + "[34m");
                            System.out.println("Total: " + p1Total);
                            //if user got 21, end hit/stay option.
                            break;
                        }

                    }

                    if (hitStand == 68 || hitStand == 100 || hitStand == 83 || hitStand == 115 || p1Total == 21) {
                        break;
                    }
                }

                //Reprint dealer cards revealing hidden card
                System.out.println((char)27 + "[35m");
                System.out.println("Dealer Cards:");
                System.out.println(" _____   _____");
                System.out.println("| " + dealerCard1 + " | | " + dealerCard2 + " |");
                System.out.println("|     | |     |");
                System.out.println(" _____   _____");
                System.out.println("");
                System.out.println("Dealer Total: " + dTotal);

                //After user played, dealer hits until value is >= 17
                while (dTotal < 17) {
                    int hitRoundCard = 3; //keeps track of how many times dealer has hit to assign next card from drawn cards array
                    for (i = hitRoundCard; dTotal < 17 && hitRoundCard < 15; ++i) {
                        System.out.println("");
                        System.out.println("Dealer hits...");
                        System.out.println("");
                        System.out.println(" _____");
                        System.out.println("| " + cardDisplay(drawnCards[i - 1][0]) + " |");
                        System.out.println("|     |");
                        System.out.println(" _____");
                        System.out.println("");
                        dTotal = dTotal + cardValue(drawnCards[i - 1][0]);
                        ++hitRoundCard;

                        //Note: still in the for-loop. Checking totals after each hit and responding appropriately

                        if (dTotal < 21 && p1Total < 22) {
                            System.out.println("Dealer Total: " + dTotal); //When less than 21, keep playing
                        }

                        //If greater than 21 need to see if Aces were drawn and adjust totals to keep from improperly saying dealer busted
                        else if (dTotal > 21) {

                            //Was first drawn card an ace?
                            if (!aceUsed[0][0] && cardValue(drawnCards[0][0]) == 11) {
                                dTotal = dTotal - 10;
                                aceUsed[0][0] = true;
                            }

                            //Was second drawn card an ace?
                            else if (!aceUsed[1][0] && cardValue(drawnCards[1][0]) == 11) {
                                dTotal = dTotal - 10;
                                aceUsed[1][0] = true;
                            }

                            //Was most recent drawn card an ace?
                            else if (!aceUsed[i - 1][0] && cardValue(drawnCards[i - 1][0]) == 11) {
                                dTotal = dTotal - 10;
                                aceUsed[i - 1][0] = true;
                            }

                            //Were any of the other drawn cards an ace (basically if you've already hit more than once)

                            else {
                                for (x = 3; x < i; ++x) {
                                    if (!aceUsed[x - 1][0] && cardValue(drawnCards[x - 1][0]) == 11) {
                                        dTotal = dTotal - 10;
                                        aceUsed[x - 1][0] = true;
                                    }
                                }
                            }

                            System.out.println("Dealer Total: " + dTotal); //Print new total after each hit with ace adjustment

                            if (dTotal > 21) {
                                System.out.println("Dealer busted.");
                                //if after all of the possible adjustments for aces didn't help, dealer busted.
                                break;
                            }
                        }

                        if (dTotal == 21) {
                            System.out.println("Dealer Total: " + dTotal);
                            //if dealer got 21, end dealer hit/stay loop.
                            break;
                        }
                    }
                }
            }

        if (!firstHand) {
            if (p1Total > dTotal && p1Total < 22) {
                //If nobody had blackjack and player beat the dealer without busting
                System.out.println((char)27 + "[32m");
                System.out.println("The dealer had " + dTotal + " vs. your total of " + p1Total + ".");
                System.out.println("You beat the dealer!");
                System.out.print("You won $");
                System.out.printf("%5.2f%n", p1Wager);
                System.out.println("");
                p1Wager = p1Wager * 2;
                p1Money = p1Money + p1Wager;
                System.out.print("You now have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
            } else if (dTotal > 21 && p1Total < 22) {
                //If the dealer busted, but player didn't - player wins
                System.out.println((char)27 + "[32m");
                System.out.println("The dealer had " + dTotal + " vs. your total of " + p1Total + ".");
                System.out.println("The dealer busted, so you beat the dealer!");
                System.out.print("You won $");
                System.out.printf("%5.2f%n", p1Wager);
                System.out.println("");
                p1Wager = p1Wager * 2;
                p1Money = p1Money + p1Wager;
                System.out.print("You now have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
            } else if (p1Total == dTotal && p1Total < 22) {
                //If you and the dealer had the same value of cards
                System.out.println((char)27 + "[37m");
                System.out.println("The dealer had " + dTotal + " vs. your total of " + p1Total + ".");
                System.out.println("You pushed. You didn\'t lose... BUT YOU DIDN\'T WIN EITHER");
                p1Money = p1Money + p1Wager;
                System.out.print("You still have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
            } else if (dTotal < 22) {
                //If nobody had blackjack, but the dealer beat you. Also displays if user busted on a hit
                System.out.println((char)27 + "[31m");
                System.out.println("The dealer had " + dTotal + " vs. your total of " + p1Total + ".");
                System.out.println("The dealer beat you. Pay up.");
                System.out.print("You lost $");
                System.out.printf("%5.2f%n", p1Wager);
                System.out.println("");
                System.out.print("You now have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
            } else {
                //if user and dealer busted, user still loses
                System.out.println((char)27 + "[31m");
                System.out.println("The dealer had " + dTotal + " vs. your total of " + p1Total + ".");
                System.out.println("The dealer busted, but so did you. Pay up.");
                System.out.print("You lost $");
                System.out.printf("%5.2f%n", p1Wager);
                System.out.println("");
                System.out.print("You now have $");
                System.out.printf("%5.2f%n", p1Money);
                System.out.println("");
            }

        }

            if (p1Money == 0) {
                //If user's total money went to zero
                System.out.println((char)27 + "[31m");
                System.out.println("Go to the ATM, poor boy.");
                break;
            }

            firstHand = false;
            //Asks if user wants to play another hand
            System.out.println((char)27 + "[37m");
            System.out.println("New Game? (Yes = Y, No = N)");
            newGameResponse = scnr.next().charAt(0);

        }

        //If player did not opt to play a new game
        System.out.println((char)27 + "[33m");
        System.out.print("Your cash out value is: $");
        System.out.printf("%5.2f%n", p1Money);
        System.out.println("");
    }
}

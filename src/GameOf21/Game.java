/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOf21;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author naree1878
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        card[] cards = new card[3];
        do {
            cards[0] = new card(r.nextInt(13) + 1); //creates the card objects with a random value
            cards[1] = new card(r.nextInt(13) + 1);
            cards[2] = new card(14); //sets the card to one without value so it will not be added unless it is need 
            System.out.println("Your cards are a " + cards[0].getName() + " and a " + cards[1].getName() + "\nWould you like another card? (Y/N)");

            if (sc.nextLine().toLowerCase().equals("y")) { //gives the user a 3rd card if needed
                cards[2] = new card(r.nextInt(13) + 1);
                System.out.println("Your new card is a " + cards[2].getName());
            }

            int sum1 = cards[0].getValue() + cards[1].getValue() + cards[2].getValue(); //adds up the cards
            for (int i = 0; i < 2; i++) {
                if (sum1 > 21) { //checks if the user is over 21
                    if (cards[i].getName().equals("Ace")) { //if the user has aces they get turned from 11's to 1's until they are under 21 
                        cards[i].setValue(1);
                        sum1 -= 10;
                    }
                }
            }
            System.out.println("You got " + sum1);

            cards[0] = new card(r.nextInt(13) + 1); //creates the card objects for the opponent
            cards[1] = new card(r.nextInt(13) + 1);
            cards[2] = new card(14);
            if (cards[0].getValue() + cards[1].getValue() < 14) { //opponent will ask for a 3rd card if they have 14 or less in their hand
                cards[2] = new card(r.nextInt(13) + 1);
            }
            int sum2 = cards[0].getValue() + cards[1].getValue() + cards[2].getValue();
            for (int i = 0; i < 2; i++) {
                if (sum2 > 21) {
                    if (cards[i].getName().equals("Ace")) {
                        cards[i].setValue(1);
                        sum1 -= 10;
                    }
                }
            }
            System.out.println("Your opponent got " + sum2);

            if (sum1 == sum2 || (sum1 > 21 && sum2 > 21)) { //checks for a tie
                System.out.println("You tie");
            } else if (sum1 <= 21 && sum2 <= 21 && (21 - sum1 < 21 - sum2)) { //checks which user is closer to 21
                System.out.println("You Win");
            } else {
                System.out.println("Your opponent wins");
            }           
            System.out.println("Play again? (y/n)");
        } while (sc.nextLine().toLowerCase().equals("y")); //loops until the user quits
    }

}

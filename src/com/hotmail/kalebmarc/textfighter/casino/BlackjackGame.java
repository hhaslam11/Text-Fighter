package com.hotmail.kalebmarc.textfighter.casino;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;

import java.util.*;

public class BlackjackGame extends BasicCasinoGame {
    private Stack<Card> cardStack;

    public BlackjackGame() {
        super("------------------------------------------------------------------\n" +
                        "                            Blackjack                           \n" +
                        "------------------------------------------------------------------",
                "You will get random cards with a value ranging from 2 to 10.\n" +
                        "There is a special card indicated by * which has either a\n" +
                        "value of 1 or 11, depending on what comes in more handy. Your goal\n" +
                        "is to get a total value of 21. With more, you loose automatically.\n" +
                        "I am trying to do the same. The one who is closer to 21 gets\n" +
                        "double the amount of coins you bet. It has to be between 10 and 250\n" +
                        "coins. You decide whether or not you receive another card.",
                "1) Let's play!\n" +
                        "2) Back to the casino menu",
                GameType.BLACKJACK);
        cardStack = null;
    }

    @Override
    public int play(int selection) {
        int bet;

        //Greeting & Input
        Ui.cls();
        Ui.println(getHeader());
        Ui.println();
        Ui.println("Coins: " + Coins.get());
        Ui.println();
        Ui.println("To begin, enter the amount of coins you would like to bet.. ");
        Ui.println("It must be between 10, and 250.");
        Ui.println("Enter 0 to go back");
        do {//Bet
            bet = Ui.getValidInt();
            if (bet == 0) return -1;
            if (bet > Coins.get()) {
                Ui.cls();
                bet = 0;
                Ui.println("You do not have enough coins. Please enter a smaller amount. (Or enter 0 to go back)");

            }
        } while (bet < 10 || bet > 250);

        Coins.set(-bet, true);

        resetCards();

        int playerScore = playerTurn();

        int casinoScore = CasinoTurn();

        // Determine winner
        Ui.cls();
        if (playerScore > casinoScore) {
            Ui.println("You won this round! Congratulations!");
            return bet * 2;
        } else if (casinoScore > playerScore) {
            Ui.println("Unfortunately you lost this time. Good luck next time!");
            return 0;
        } else {
            Ui.println("This round is a match. You get your bet back.");
            return bet;
        }
    }

    /**
     * Lets the player play his round of blackjack
     * @return int Score achieved by player. Scores above 21 will result in 0
     */
    private int playerTurn() {
         List<Card> drawnCards = new LinkedList<>();
         boolean exit = false;

         // Ask the player to draw more cards
         do{
             // Draw cards
             Card drawn = drawCard();
             drawnCards.add(drawn);
             Ui.cls();
             Ui.println("You drew a " + drawn.getName());
             Ui.pause();

             // Shows current cards and drawn cards
             Ui.cls();
             Ui.println(getHeader());
             Ui.println();
             Ui.print("Cards:");
             // Draw every card
             for(int i = 0; i < drawnCards.size(); i++){
                 Ui.print(" " + drawnCards.get(i));
                 if(i+1 < drawnCards.size()){
                     Ui.print(",");
                 }
             }
             // Value of cards
             Ui.println("Value: " + highestPossibleValue(drawnCards));
             Ui.println();

             // Check for too much points
             if(highestPossibleValue(drawnCards) > 21){
                 Ui.println("Unfortunately you got more than 21 points, resulting in a total of 0 points!");
                 Ui.pause();
                 break;
             }else {
                 Ui.println("Would you like to draw another card?");
                 Ui.println("1) Take another card");
                 Ui.println("2) Stop taking cards");
             }

             // Input
             boolean quitInput = false;
             while(!quitInput) {
                 int menuChoice = Ui.getValidInt();

                 switch (menuChoice) {
                     case 1:
                         quitInput = true;
                         break;
                     case 2:
                         exit = true;
                         quitInput = true;
                         break;
                     default:
                         break;
                 }
             }

         }while(!exit);

         if(highestPossibleValue(drawnCards) > 21){
             return 0;
         }else{
             return highestPossibleValue(drawnCards);
         }
    }

    /**
     * The computer plays his round, progress is shown to the player
     * @return int Score achieved by the casino. Scores above 21 will result in 0
     */
    private int CasinoTurn() {
        List<Card> drawnCards = new LinkedList<>();
        boolean exit = false;

        // Determine to draw more cards
        do{
            // Draw cards
            Card drawn = drawCard();
            drawnCards.add(drawn);
            Ui.cls();
            Ui.println("Casino drew a " + drawn.getName());
            Ui.pause();

            // Shows current cards and drawn cards
            Ui.cls();
            Ui.println(getHeader());
            Ui.println();
            Ui.print("Casino's cards:");
            // Draw every card
            for(int i = 0; i < drawnCards.size(); i++){
                Ui.print(" " + drawnCards.get(i));
                if(i+1 < drawnCards.size()){
                    Ui.print(",");
                }
            }
            // Value of cards
            Ui.println("Casino's value: " + highestPossibleValue(drawnCards));
            Ui.println();

            // Check for too much points
            if(highestPossibleValue(drawnCards) > 21){
                Ui.println("The casino drew more than a total of 21, resulting in its loss!");
                Ui.pause();
                break;
            }

            // Simple "AI" to determine the exit condition
            if(highestPossibleValue(drawnCards) > 17){
                exit = true;
                Ui.println("The casino stopped playing!");

            }else if(highestPossibleValue(drawnCards) > 15) {
                if (Math.random() < 0.5D) {
                    exit = true;
                    Ui.println("The casino stopped playing!");
                }
            }

        }while(!exit);

        if(highestPossibleValue(drawnCards) > 21){
            return 0;
        }else{
            return highestPossibleValue(drawnCards);
        }
    }

    /**
     * Calculates the highest possible value of the cards
     *
     * @param cards the Card List the value should be determined from
     * @return int The whole value including * cards
     */
    private int highestPossibleValue(List<Card> cards){
        int value = 0;
        int assCounter = 0;

        // Calculate the value without taking * into account
        for(Card card : cards){
            value += card.getValue();
            if(card.getName().equals("*")) assCounter++;
        }

        // Subtracts value of *
        for(int i = 0; i < assCounter; i++){
            if(value <= 21)
                break;
            value -= 10;
        }

        return value;
    }

    /**
     * Helper method to draw cards.
     * @return Card random card drawn
     */
    private Card drawCard(){
        return cardStack.pop();
    }

    private void resetCards() {
        cardStack = new Stack<>();

        // Defining Cards
        Card ass = new Card(11, "*");
        Card ten = new Card(10, "10");
        Card nine = new Card(9, "9");
        Card eight = new Card(8, "8");
        Card seven = new Card(7, "7");
        Card six = new Card(6, "6");
        Card five = new Card(5, "5");
        Card four = new Card(4, "4");
        Card three = new Card(3, "3");
        Card two = new Card(2, "2");

        // Add cards and shuffle them
        cardStack.addAll(Arrays.asList(ass, ass, ten, ten, nine, nine, eight, eight, seven, seven, six, six, five, five, four, four, three, three, two, two));
        Collections.shuffle(cardStack);
    }

    @Override
    protected int getExitEntry() {
        return 2;
    }

    private static class Card{
        private final int value;
        private final String name;

        public Card(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }
    }
}

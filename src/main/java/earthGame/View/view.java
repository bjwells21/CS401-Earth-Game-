package earthGame.View;

import earthGame.Model.Card;
import earthGame.Model.Player;
import earthGame.Model.ClimateCard;
import earthGame.Model.IslandCard;
import java.util.Scanner;

/*
 * This is a console view of the board game "Earth"
 *
 */

/*
    User Stories:
    As a player, I want to be able to draw cards.
    As a player, I want to be able to discard cards.
    As a player, I want to be able to view the cards in my hand.
    As a player, I want to be able to view the amount of points I have.

 */
public class view {
    // fauna board
    Card cards;
    Player[] players;
    // Deck deck;
    private final Scanner stdin = new Scanner(System.in);
    int NUM_PLAYERS = 0;
    private static final String QUIT = "Q";


    public view() {
        // fauna board
        // initialize cards
        // deck = new Deck();
        intro();
    }

    // function to ask user for number of players (1-5) and initializes them
    public void initPlayers(){
        System.out.println("Game will now begin...");
        do{
            System.out.print("Enter number of players (1-5): ");
            NUM_PLAYERS = stdin.nextInt();
            if(NUM_PLAYERS > 5 || NUM_PLAYERS < 1){
                System.out.println("Please enter a number between 1-5");
            }
        } while(NUM_PLAYERS > 5 || NUM_PLAYERS < 1);

        players = new Player[NUM_PLAYERS];
        for(int playerIndex = 0; playerIndex < NUM_PLAYERS; playerIndex++){
            players[playerIndex] = new Player(0, playerIndex);
        }
    }

    // deals a climate card and island card to each player at the beginning of the game
    public void dealStartingCards(){
        System.out.println("");
        System.out.println("Dealing starting Island and Climate Cards to all players...");
        System.out.println("");
        int currentPlayer = 1;
        for(int nextPlayer = 0; nextPlayer < NUM_PLAYERS; nextPlayer++){
            System.out.println("Current player = " + currentPlayer + " Total players = " + NUM_PLAYERS);
            currentPlayer += 1;
            players[nextPlayer].addToHand(ClimateCard.randomDrawCard());
            players[nextPlayer].addToHand(IslandCard.randomDrawCard());
            System.out.println(players[nextPlayer].viewHand());
        }
    }

    public boolean intro() {
        String quit;
        // asks user to either quit or continue with game
        System.out.println("Welcome to Earth Board Game! (console based version)");
        System.out.print("Enter " + QUIT + " to quit, any other nonblank to continue: ");
        quit = stdin.next().toUpperCase();
        if (quit.equals(QUIT)){
            return false;
        }

        // continue with game
        initPlayers();
        dealStartingCards();

        return true;
    }

    private void exit() {
    }

    public static void main(String[] args) {
        // run the game
        view game = new view();
    }
}

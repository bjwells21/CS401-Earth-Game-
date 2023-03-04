package earthGame;

import java.util.Scanner;

/*
 * This is a console view of the board game "Earth"
 *
 */
public class view {
    faunaBoard fboard;
    // cards
    Player[] players;
    Deck deck;
    private Scanner stdin = new Scanner(System.in);
    private static final String QUIT = "Q";


    public view() {
        fboard = new faunaBoard();
        // initialize cards
        deck = new Deck();
        intro();
        initPlayers();
    }

    private void intro() {
        System.out.println("");
    }

    private void initPlayers() {
        System.out.println("Enter number of players(1-5): ");
        int NUM_PLAYERS = stdin.nextInt();
        players = new Player[NUM_PLAYERS];
        for (int playerIndex = 0; playerIndex < NUM_PLAYERS; playerIndex++) {
            // add player
        }
        // implement for loop to ask for names
        // implement function to shuffle and deal cards
        // implement function to choose a random starting player
    }

    public static void main(String[] args) {
        // run the game
    }
}

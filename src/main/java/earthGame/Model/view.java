package earthGame.Model;

import java.util.Random;
import java.util.Scanner;

/*
 * This is a console view of the board game "Earth"
 *
 */
public class view {
    // fauna board
    Card cards;
    Player[] players;
    // Deck deck;
    private Scanner stdin = new Scanner(System.in);
    static final int NUM_PLAYERS = 2;
    // private static final String QUIT = "Q";


    public view(int numPlayers) {
        // fboard = new faunaBoard();
        // initialize cards
        // deck = new Deck();
        intro();
        playGame();
    }

    private void intro() {
        System.out.println("Welcome to Earth Board Game!");
    }

    private void playGame() {
        // System.out.println("Enter number of players(1-5): ");
        // int NUM_PLAYERS = stdin.nextInt();
        // STATIC NUMBER OF PLAYERS (TEMPORARY)
       // String name;
        // for loop to create specified number of players
        players = new Player[NUM_PLAYERS];
        for (int playerIndex = 1; playerIndex < NUM_PLAYERS+1; playerIndex++) {
            // add player
            //players[playerIndex] = new Player(name);
            System.out.println("Created Player " + playerIndex );
        }

        // implement function to shuffle and deal cards
        // implement function to choose a random starting player
        // int rand = (Math.random() <= 0.5) ? 1 : 2;
        System.out.println("Player 1 will go first");
        System.out.println("Player 1 draws an Island card and Climate card");
        ClimateCard cc = new ClimateCard();
        IslandCard ic = new IslandCard();
        System.out.println("Player 1 draws cards \n" + cc.randomDrawCard() + ic.randomDrawCard());
        System.out.println("Player 2 draws cards \n" + cc.randomDrawCard() + ic.randomDrawCard());



    }

    public static void main(String[] args) {
        // run the game
        view game = new view(NUM_PLAYERS);
    }
}

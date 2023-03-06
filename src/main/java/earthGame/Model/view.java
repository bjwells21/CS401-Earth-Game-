package earthGame.Model;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

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

        int playerCount = 1;
        players = new Player[NUM_PLAYERS];
        for (int playerIndex = 1; playerIndex < NUM_PLAYERS+1; playerIndex++) {
            // add player
            //players[playerIndex] = new Player(name);
            System.out.println("Created Player " + playerIndex );
        }
        // implement function to shuffle and deal cards
        // implement function to choose a random starting player
        // int rand = (Math.random() <= 0.5) ? 1 : 2;
        System.out.println("Player " + playerCount + " will go first");
        for(int i = 0; i < NUM_PLAYERS; i++){
            System.out.print("Player " + playerCount + " - Draw Cards?(y/n): ");
            String response = stdin.next();
            if(Objects.equals(response, "y")){
                System.out.println("Player " + playerCount + " cards");
                System.out.println("-------------------------- \n"
                        + ClimateCard.randomDrawCard() + "\n"
                        + IslandCard.randomDrawCard());
            }
            else {
                System.out.println("Thank you for playing!");
                System.out.println("Game Ending...");
                exit();
            }
            playerCount += 1;
        }
    }

    private void exit() {
    }

    public static void main(String[] args) {
        // run the game
        view game = new view(NUM_PLAYERS);
    }
}

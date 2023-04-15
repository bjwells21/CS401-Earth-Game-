package earthGame.Controller;

import earthGame.Model.ClimateCard;
import earthGame.Model.IslandCard;
import earthGame.Model.Player;

import java.util.Objects;
import java.util.Scanner;

public class gameRules {
    private Player[] players;
    private int diceRoll;
    private int currentPlayer;      //this is an index in the player array
    private final Scanner stdin = new Scanner(System.in);
    String response;
    int switchInput;

    public gameRules(int numPlayers){
        players = new Player[numPlayers];
        for(int playerIndex = 1; playerIndex < numPlayers+1; playerIndex++){
            //perhaps have player cards set up here? board set up?
            System.out.println("Created player " + playerIndex);
        }

        System.out.println("Player 1 will go first");

        for(int i = 0; i < numPlayers; i++){
            /*
                portion of code reserved for having player pick one of 3 tiles
                also evaluating and doing the effect of the tiles
             */
            System.out.print("which tile you you like to choose? " +
                    "1)Plant\n2)Composting\n3)Watering");
            switchInput = stdin.nextInt();

            switch(switchInput){
                case 1: {
                    System.out.println("you have selected the plant phase.");
                }
                case 2:{
                    System.out.println("you have selected composting");
                }
                case 3:{
                    System.out.println("you have selected watering");
                }
                default:{
                    System.out.println("a valid option was not selected");
                }
            }
            /*
            portion of code reserved for
             */
            System.out.print("Player " + currentPlayer + " draw cards? Enter Y/N");
            String response = stdin.next();
            if(Objects.equals(response, "y")){
                System.out.println("Player " + currentPlayer + " cards");
                System.out.println("---------------------\n"
                        + ClimateCard.randomDrawCard() + "\n"
                        + IslandCard.randomDrawCard());
            }
            else{
                System.out.println("Thank you for playing");
                System.out.println("Game ending...");
                exit();
            }
            currentPlayer += 1;

        }
    }
    public int diceRoll(){
        return ((int)(Math.random() * 6) + 1);
    }
    private void exit(){
        return;
    }
}
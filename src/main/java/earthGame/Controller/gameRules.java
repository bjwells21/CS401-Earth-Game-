package earthGame.Controller;
/*
controller class that controls the game flow (player turn, player action, endgame state etc) and game
rules such win conditions, taking action (choosing water/compost/planting tiles).

It will also integrate all the other classes and operate upon the model data to produce results.
The results will have their data printed by the view class.

To do list:
-----------
1) implement player action (choosing tiles) -> controller
2) have deck/player hand implementations up and running -> player class/view
3) implement player utility (checking their tableau, how many points they have) -> player class/view
4) implement card effects and tableau interactions
5) implement end game conditions -> player class
 */


import earthGame.Model.*;
import earthGame.View.*;

import java.util.Objects;
import java.util.Scanner;

public class gameRules {
    private Player[] players;
    Card cards;
    private int NUM_PLAYERS;
    private int currentPlayer;      //this is an index in the player array
    private final Scanner stdin = new Scanner(System.in);
    String response;
    int switchInput;
    view newView = new view();

    public gameRules(){
        ;

        boolean entryTest = newView.intro();
        if(entryTest == false){exit();}
        else{
            initPlayers();
            dealStartingCards();

            for(int i = 1; i < NUM_PLAYERS; i++){

            /*
                portion of code reserved for having player pick one of 3 tiles
                also evaluating and doing the effect of the tiles
             */
                newView.display("which tile you you like to choose? " +
                        "\n0)Quit\n1)Plant\n2)Composting\n3)Watering" +
                        "\n4)check tableau");
                switchInput = stdin.nextInt();

                switch(switchInput){
                    case 0:{
                        exit();
                        break;
                    }
                    case 1: {
                        newView.display("you have selected the plant phase.");
                        /*

                         */
                        break;
                    }
                    case 2:{
                        newView.display("you have selected composting");
                        break;
                    }
                    case 3:{
                        newView.display("you have selected watering");
                        break;
                    }
                    case 4:{
                        break;
                    }
                    default:{
                        newView.display("a valid option was not selected");
                        break;
                    }
                }
            /*

             */
                if(i == NUM_PLAYERS){ i = 1;}        //ensures rotation of players is conserved

            }
        }
    }
    public void initPlayers() {

        newView.display("Game will now begin...");

        do {
            newView.display("Enter number of players (1-5): ");
            this.NUM_PLAYERS = this.stdin.nextInt();
            if (this.NUM_PLAYERS > 5 || this.NUM_PLAYERS < 1) {
                newView.display("Please enter a number between 1-5");
            }
        } while(this.NUM_PLAYERS > 5 || this.NUM_PLAYERS < 1);

        this.players = new Player[this.NUM_PLAYERS];

        for(int playerIndex = 0; playerIndex < this.NUM_PLAYERS; ++playerIndex) {
            this.players[playerIndex] = new Player(0, playerIndex);
        }

    }
    public void dealStartingCards(){

        newView.display("");
        newView.display("Dealing starting Island and Climate Cards to all players...");
        newView.display("");
        int currentPlayer = 1;
        for(int nextPlayer = 0; nextPlayer < NUM_PLAYERS; nextPlayer++){
            newView.display("Current player = " + currentPlayer + " Total players = " + NUM_PLAYERS);
            currentPlayer += 1;
            players[nextPlayer].addToHand(cardDeck.randomDrawClimateCard());
            players[nextPlayer].addToHand(cardDeck.randomDrawIslandCard());
            newView.display(players[nextPlayer].viewHand());
        }
    }

    private void exit(){

        newView.display("Thank you for playing");
        newView.display("Game ending...");
        System.exit(0);
    }
}

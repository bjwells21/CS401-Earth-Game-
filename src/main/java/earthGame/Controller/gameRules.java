package earthGame.Controller;


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
    //view newView;

    public gameRules(int numPlayers){
        view newView = new view();
        boolean entryTest = newView.intro();
        if(entryTest == false){exit();}
        else{
            initPlayers();
            dealStartingCards();

            for(int i = 0; i < numPlayers; i++){
            /*
                portion of code reserved for having player pick one of 3 tiles
                also evaluating and doing the effect of the tiles
             */
                System.out.print("which tile you you like to choose? " +
                        "\n0)Quit\n1)Plant\n2)Composting\n3)Watering");
                switchInput = stdin.nextInt();

                switch(switchInput){
                    case 0:{
                        exit();
                        break;
                    }
                    case 1: {
                        System.out.println("you have selected the plant phase.");
                        break;
                    }
                    case 2:{
                        System.out.println("you have selected composting");
                        break;
                    }
                    case 3:{
                        System.out.println("you have selected watering");
                        break;
                    }
                    default:{
                        System.out.println("a valid option was not selected");
                        break;
                    }
                }
            /*
            portion of code reserved for player choosing a particular tab
             */

            }
        }
    }
    public void initPlayers() {
        System.out.println("Game will now begin...");

        do {
            System.out.print("Enter number of players (1-5): ");
            this.NUM_PLAYERS = this.stdin.nextInt();
            if (this.NUM_PLAYERS > 5 || this.NUM_PLAYERS < 1) {
                System.out.println("Please enter a number between 1-5");
            }
        } while(this.NUM_PLAYERS > 5 || this.NUM_PLAYERS < 1);

        this.players = new Player[this.NUM_PLAYERS];

        for(int playerIndex = 0; playerIndex < this.NUM_PLAYERS; ++playerIndex) {
            this.players[playerIndex] = new Player(0, playerIndex);
        }

    }
    public void dealStartingCards() {
        System.out.println("");
        System.out.println("Dealing starting Island and Climate Cards to all players...");
        System.out.println("");
        int currentPlayer = 1;

        for(int nextPlayer = 0; nextPlayer < this.NUM_PLAYERS; ++nextPlayer) {
            System.out.println("Current player = " + currentPlayer + " Total players = " + this.NUM_PLAYERS);
            ++currentPlayer;
            this.players[nextPlayer].addToHand(ClimateCard.randomDrawCard());
            this.players[nextPlayer].addToHand(IslandCard.randomDrawCard());
            System.out.println(this.players[nextPlayer].viewHand());
        }

    }

    private void exit(){
        System.out.println("Thank you for playing");
        System.out.println("Game ending...");
        System.exit(0);
    }
}

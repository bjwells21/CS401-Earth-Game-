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

        boolean entryTest = newView.intro();
        if(entryTest == false){exit();}
        else{
            initPlayers();
            dealStartingCards();

            for(int i = 1; i <= NUM_PLAYERS; i++){

            /*
                portion of code reserved for having player pick one of 3 tiles
                also evaluating and doing the effect of the tiles
             */
                newView.display("which tile you you like to choose? " +
                        "\n0)Quit\n1)Plant\n2)Composting\n3)Watering" +
                        "\n4)check player inventory");
                switchInput = stdin.nextInt();
                stdin.nextLine();

                switch(switchInput){
                    case 0:{
                        exit();
                        break;
                    }
                    case 1: {
                        //have code here that does the plant phase
                        newView.display("you have selected the plant phase.");
                        break;
                    }
                    case 2:{
                        //have code that does the composting phase
                        newView.display("you have selected composting");
                        break;
                    }
                    case 3:{
                        //have code here that does the watering phase
                        newView.display("you have selected watering");
                        break;
                    }
                    case 4:{
                        //code here that checks player tableau, current hand and point total
                        newView.display("you decided to check your inventory");
                        break;
                    }
                    default:{
                        newView.display("a valid option was not selected");
                        break;
                    }
                }

                System.out.println("i currently is: " + i +" and number of players is: " + NUM_PLAYERS);
                if(i == NUM_PLAYERS){ i = 1;}        //ensures rotation of players is conserved

            }
        }
    }
    public void initPlayers() {

        newView.display("Game will now begin...");

        NUM_PLAYERS = 2;
        this.players = new Player[NUM_PLAYERS];

        for(int playerIndex = 0; playerIndex < this.NUM_PLAYERS; ++playerIndex) {
            this.players[playerIndex] = new Player(0, playerIndex);
        }
        newView.display("you are player 1");
        currentPlayer = 0;      //0th index

    }
    public void dealStartingCards(){

        newView.display("");
        newView.display("Dealing starting Island and Climate Cards to all players...");
        newView.display("");

        for(int nextPlayer = 0; nextPlayer < NUM_PLAYERS; nextPlayer++){
            newView.display("dealing cards to player " + (nextPlayer + 1));
            //perhaps have a arraylist of random climate and island cards?

            //players[nextPlayer].addToHand(cardDeck.randomDrawClimateCard());
            //players[nextPlayer].addToHand(cardDeck.randomDrawIslandCard());

            IslandCard starterIsland = cardDeck.randomDrawIslandCard();
            players[currentPlayer].setIsland(cardDeck.randomDrawIslandCard());
            starterIsland.abilityEffect(players[currentPlayer]);//play the players island ability (since its black)
            /*
            player must draw, compost, and add x soil.
            1) Draw will be a cardDeck of some random cards, added to player hand
            2) player will then examine hand and choose which cards to compost. This will probably call a compost func
            3) simply add X soil. Done via IslandCard class?
             */

            //create a deck of random cards made of 200+ cards
            int IslanddrawCount = 4;
            for(int i = 0; i < IslanddrawCount; i++){

                Card drawnCard = cardDeck.randomDrawClimateCard();
                players[currentPlayer].addToHand(drawnCard);
            }
            // to enquire: have player card (1st card is ... 2nd card is... etc)
            newView.display("Island card drew: " + players[currentPlayer].getHandSize() + " cards");
            newView.display("current hand: " + players[currentPlayer].viewHand());
            newView.display("please compost 3 cards");
            //code here to compost player hands
            starterIsland.initialEffect(players[currentPlayer]);

            exit();


        }

    }



    private void exit(){

        newView.display("Thank you for playing");
        newView.display("Game ending...");
        System.exit(0);
    }


}

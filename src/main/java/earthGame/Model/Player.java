package earthGame.Model;

import java.util.ArrayList;

public class Player{
    // array list to represent user's hand
    ArrayList<Card> hand;
    // every player has an island card and a climate card
    Card island, climate;
    // every player has a 4x4 tableau to plant their cards
    Card[][] tableau = new Card[4][4];
    boolean activePlayer, finishFirst;
    // every player has soil, compost, and Victory Points
    int soil, faunaObj, totalVPoints, compost, playerNumber;
    // maybe add growthTokens?

    // constructor for Player object, initialized with starting soil and if they are the first player in the rotation.
    public Player(int startSoil, int playerNum) {
        hand = new ArrayList<Card>();
        compost = 0;
        faunaObj = 0;
        totalVPoints = 0;
        soil = startSoil;
        playerNumber = playerNum;
        finishFirst = false;
    }
    // function to add to the player's compost
    void addCompost(int numCompost){
        if (numCompost > 0)
            compost+=numCompost;
    }

    // function to get the player's compost
    int getCompost(){
        if (compost < 0)
            compost = 0;
        return compost;
    }

    // function to return the amount of points the user has
    int getPoints(){
        if (totalVPoints < 0)
            totalVPoints = 0;
        return totalVPoints;
    }

    // add points to total victory points
    void addPoints (int points) {
        if (points > 0)
            totalVPoints+=points;
    }

    // getter function to return soil
    int getSoil() {
        if (soil < 0) { soil = 0;}
        return soil;
    }

    // adder function to add soil
    void addSoil(int numOfSoil){
        if (soil > 0){ soil+=numOfSoil; }
    }

    // removes soil from the player
    void useSoil(int numOfSoil) {
        soil-=numOfSoil;
        if (soil < 0){ soil = 0;}
    }

    // prototype: puts an island card and a climate card in user's hands
    void addToHand(int numberOfCards) {
        if (numberOfCards > 0) {
            while (numberOfCards != 0) {
                hand.add(IslandCard.randomDrawCard());
                numberOfCards--;
            }
        }
    }
    // function to view the player's hand
    String viewHand() {
        String viewHand = "";
        for (Card c : hand)
            viewHand += c.toString() + "\n";
        return viewHand;
    }
    @Override
    public String toString(){
        String playerData="";
        playerData += "Player " + playerNumber + ":\n-----------\n"
         + "Compost: " + compost + "\n"
         + "Soil: " + soil + "\n"
         + "VPoints: " + totalVPoints + "\n";
        return playerData;
    }
}
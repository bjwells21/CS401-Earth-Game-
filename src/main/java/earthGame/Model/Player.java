package earthGame.Model;

import java.util.ArrayList;

class Player{
    // array list to represent user's hand
    ArrayList<Card> hand;
    // every player has an island card and a climate card
    Card island, climate;
    // every player has a 4x4 tableau to plant their cards
    Card[][] tableau = new Card[4][4];
    boolean activePlayer, firstPlayer, finishFirst;
    // every player has soil, compost, and Victory Points
    int soil, faunaObj, totalVPoints, compost;
    // maybe add growthTokens?

    // constructor for Player object, initialized with starting soil and if they are the first player in the rotation.
    public Player(int startSoil, boolean isFirst) {
        hand = new ArrayList<Card>();
        compost = 0;
        faunaObj = 0;
        totalVPoints = 0;
        soil = startSoil;
        firstPlayer = isFirst;
        finishFirst = false;
    }
    // function to add to the player's compost
    void addCompost(int numCompost){
        compost+=numCompost;
    }

    // function to get the player's compost
    int getCompost(){
        return compost;
    }

    // function to return the amount of points the user has
    int getPoints(){
        return totalVPoints;
    }

    // add points to total victory points
    void addPoints (int points) {
        totalVPoints+=points;
    }

    // getter function to return soil
    int getSoil() {
        return soil;
    }

    // adder function to add soil
    void addSoil(int numOfSoil) {
        soil+=numOfSoil;
    }

    // removes soil from the player
    void useSoil(int numOfSoil) {
        soil-=numOfSoil;
    }

    // prototype: puts an island card and a climate card in user's hands
    void addToHand(int numberOfCards) {
        hand.add(IslandCard.randomDrawCard());
        hand.add(ClimateCard.randomDrawCard());
    }

    // function to view the player's hand
    void viewHand() {
        for (int i=0;i<hand.size();i++) {
            hand.get(i).toString();

        }
    }
}
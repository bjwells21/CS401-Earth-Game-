package earthGame.Model;

import java.util.ArrayList;

public class Player{
    // array list to represent user's hand
    private ArrayList<Card> hand;
    // every player has an island card and a climate card
    private Card island, climate;
    // every player has a 4x4 tableau to plant their cards
    public Card[][] tableau;
    private boolean activePlayer, finishFirst;
    // every player has soil, compost, and Victory Points
    private int soil, totalVPoints, compost, playerNumber, sprouts;

    // maybe add growthTokens?

    // constructor for Player object, initialized with starting soil and if they are the first player in the rotation.
    public Player(int startSoil, int playerNum) {
        hand = new ArrayList<Card>();
        compost = 0;
        totalVPoints = 0;
        soil = startSoil;
        playerNumber = playerNum;
        finishFirst = false;
        tableau = new Card[4][4];
    }
    // function to add to the player's compost
    public void addCompost(int numCompost){
        if (numCompost > 0)
            compost+=numCompost;
    }

    // function to get the player's compost
    public int getCompost(){
        if (compost < 0)
            compost = 0;
        return compost;
    }

    // function to return the amount of points the user has
    public int getPoints(){
        if (totalVPoints < 0)
            totalVPoints = 0;
        return totalVPoints;
    }

    // add points to total victory points
    public void addPoints (int points) {
        if (points > 0)
            totalVPoints+=points;
    }

    // getter function to return soil
    public int getSoil() {
        if (soil < 0) { soil = 0;}
        return soil;
    }

    // adder function to add soil
    public void addSoil(int numOfSoil){
        if (numOfSoil > 0)
            soil+=numOfSoil;
    }

    // removes soil from the player
    public void useSoil(int numOfSoil) {
        soil-=numOfSoil;
        if (soil < 0){ soil = 0;}
    }
    public int getHandSize(){
        return hand.size();
    }
    public void addToHand(Card c) {
        hand.add(c);
    }
    public void addToTableau(Card c,int posX, int posY){
        if (tableau[posX][posY] == null) {
            tableau[posX][posY] = c;
        }
    }
    // function to view the player's hand
    public String viewHand() {
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

    public void removeCard(Card c){
        hand.remove(c);
    }

    public Card getCardFromHand(int index){
        return hand.get(index);
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public boolean isTableauFull(){
        int numCardsTableau=0;
        for(int i=0;i<tableau.length;i++){
            for(int j=0;j<tableau[i].length;j++){
                if (!(tableau[i][j] == null))
                    numCardsTableau++;
            }
        }
        return numCardsTableau == 16;
    }

    public Card[][] getTableau(){
        return tableau;
    }

    public void drawFromDeck(cardDeck deck){
        hand.add((Card) deck.drawCard());
    }
    public boolean isActivePlayer(){ return activePlayer;}

    public void winConditionMet(){
        if (this.isTableauFull()) {
            finishFirst = true;
        }
    }
    public int getSprouts(){
        return sprouts;
    }

    public void addSprouts(int s){
        sprouts+=s;
    }

    public void clearPlayerSprouts(){
        sprouts-=sprouts;
    }

    public void addSproutsToTableau(int posX, int posY, int amt){
        if(tableau[posX][posY] != null){

        }
    }
}
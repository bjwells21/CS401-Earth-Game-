package earthGame;

import java.util.ArrayList;

class Player{
    ArrayList<Card> hand;
    Card island, climate;
    Card[][] tableau = new Card[4][4];
    boolean activePlayer, firstPlayer, finishFirst;
    int soil, faunaObj, totalVPoints, compost;
    // maybe add growthTokens?

    public Player(int startSoil, boolean isFirst) {
        hand = new ArrayList<Card>();
        compost = 0;
        faunaObj = 0;
        totalVPoints = 0;
        soil = startSoil;
        firstPlayer = isFirst;
        finishFirst = false;
    }

    void addPoints (int points) {
        totalVPoints+=points;
    }

    int getSoil() {
        return soil;
    }

    void addSoil(int numOfSoil) {
        soil+=numOfSoil;
    }

    void useSoil(int numOfSoil) {
        soil-=numOfSoil;
    }

    //void addToHand(int numberOfCards) {
    //	for(int i=0;i<numberOfCards;i++){
    // 		hand.add(Draw());
    //}}

    /* void viewHand(){
     * 	for (int i=0;i<hands.size();i++){
     * 		printCard(hands.get(i));
     * }
     * }
     */
}
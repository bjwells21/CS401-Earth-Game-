package earthGame.Model;

public class plantAction {
    public boolean isAdjacent(Player player,int posX, int posY){
        if (player.tableau[posX+1][posY] != null){
            return true;
        } else if (player.tableau[posX-1][posY] != null){
            return true;
        } else if (player.tableau[posX][posY+1] != null){
            return true;
        } else if (player.tableau[posX][posY-1] != null){
            return true;
        } else if (player.tableau[posX-1][posY+1] != null){
            return true;
        } else if (player.tableau[posX-1][posY-1] != null){
            return true;
        } else if (player.tableau[posX+1][posY+1] != null) {
            return true;
        } else if (player.tableau[posX+1][posY-1] != null){
            return true;
        } else
        return false;
    }
    public void keepOneCard(Card[] cards, int cardToKeepPosition, Player player/*,cardDeck discard*/){
        for (int i=0;i<cards.length;i++) {
            if (i == cardToKeepPosition) {
                player.addToHand(cards[cardToKeepPosition]);
            }
            // STILL NEED TO ADD THROWAWAY CARDS TO DISCARD PILE!!!
        }
    }
    public void drawCardsPlantAction(Player player, cardDeck deck){
        if (player.isActivePlayer() == true){
            Card[] newCards = new Card[4];
            // will revise
            newCards[0] = (Card) deck.drawCard();
            newCards[1] = (Card) deck.drawCard();
            newCards[2] = (Card) deck.drawCard();
            newCards[3] = (Card) deck.drawCard();
            // have to prompt user in view for card they want to keep
            keepOneCard(newCards,0,player);
        } else {
            player.drawFromDeck(deck);
        }
    }
    public void plantToTableau(Card card, Player player, int posX, int posY){
        // STILL NEED TO DECREMENT SOIL COST FROM PLAYER!!!
        if (player.getHandSize()==0){
            player.addToTableau(card, posX, posY);
        } else {
            if (isAdjacent(player,posX,posY)){
                player.addToTableau(card,posX,posY);
            }
        }
    }
    //STILL NEED TO IMPLEMENT ACTIVATION OF GREEN CARDS HERE!!
}

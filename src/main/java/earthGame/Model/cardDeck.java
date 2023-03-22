package earthGame.Model;
import java.util.ArrayList;
import java.util.Collections;
/*
the cardDeck class takes a generic array list  and builds a deck class with it with methods to support deck
operations of card games.
methods:
buildDeck - accepts a deck size and array list of cards, recreates a 1 to 1 in cardEck format
return DeckSize - returns  size of the carddeck
drawCard - draws a card and returns it to user. this is destructive of the deck
isDeckEmpty- checks if deck is empty
shuffle - drawing from the collections methods, shuffles the elements of the deck
 */
public class cardDeck<T> {
    ArrayList<T> cards;

    cardDeck(ArrayList<T> cards){
        this.cards = cards;
    }
    cardDeck(){
        cards = new ArrayList<T>();
    }
    void buildDeck(int deckSize,ArrayList<T> othercards ){
        for(int i = 0; i < deckSize; i++){
            cards.add(othercards.get(i));
        }
    }

    int returnDeckSize(){
        return cards.size();
    }

    T drawCard(cardDeck cards){
       if(isDeckEmpty()){
           //call a View class method here
           throw new RuntimeException("Cannot draw from a empty deck");
       }
       else{
           return this.cards.remove(0);
       }
    }

    boolean isDeckEmpty(){
        return cards.isEmpty();
    }

    void shuffle(){
        Collections.shuffle(cards);
    }


}

package earthGame.Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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

/*
As a player, I want to be able to draw a card from the deck,
so that I can play the game using the deck I have built.

goal of implementation: create a draw method. Make it so the pull is destructive to the
deck (pulling on the deck decrements it).
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

    //function used to draw a random card from all Island cards
    //Used by the player class in assigning each user their beginning Island card
    //currently allows for duplicates will need to be fixed in the future

    //User Story: As a player I want to be able to draw a random Island card to set up my game
    public static IslandCard randomDrawIslandCard(){
        Islands tmp = Islands.values()[new Random().nextInt(Islands.values().length)];
        return new IslandCard(tmp.name());
    }

    //function used to draw a random card from all Climate cards
    //Used by the player class in assigning each user their beginning climate card
    //currently allows for duplicates will need to be fixed in the future

    //User Story: As a player I want to be able to draw a random Climate card to setup my game
    public static ClimateCard randomDrawClimateCard(){
        //get a random enum and return an object initialized with that name card
        Climate tmp = Climate.values()[new Random().nextInt(Climate.values().length)];
        return new ClimateCard(tmp.name());
    }

    void shuffle(){
        Collections.shuffle(cards);
    }


}

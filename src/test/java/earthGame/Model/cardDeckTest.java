package earthGame.Model;

import earthGame.Model.cardDeck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class cardDeckTest<T> {
    ArrayList<T> cards;
    public class sampleCard {
        int cardValue;
        Random determinateRandom  = new Random();
        /*sampleCard(){
            cardValue = determinateRandom.nextInt();
        }*/
        sampleCard(int val){
            cardValue = val;
        }
        sampleCard(){
            cardValue = 0;
        }
        int getValue(sampleCard card){
            return card.cardValue;
        }
    }


    @Test
    void buildDeck(){
        ArrayList<sampleCard> sampleDeck = new ArrayList<sampleCard>();
        sampleDeck.add(new sampleCard(7));
        sampleDeck.add(new sampleCard(5));

        cardDeck deck = new cardDeck();
        deck.buildDeck(sampleDeck.size(), sampleDeck);

        System.out.println("printing the contents of the deck");
        for(int i = 0; i < deck.returnDeckSize(); i++){
            //int cardVal = deck.drawCard();
            sampleCard newCard = (sampleCard) deck.cards.get(i);
            System.out.println(newCard.cardValue);
        }
        assertEquals(2, deck.returnDeckSize());
        sampleCard newCard = (sampleCard) deck.cards.get(0);
        assertTrue(newCard.cardValue == 7);


    }

    @Test
    void drawCard() {
        ArrayList<sampleCard> sampleDeck = new ArrayList<sampleCard>();
        sampleDeck.add(new sampleCard(7));
        sampleDeck.add(new sampleCard(5));

        cardDeck deck = new cardDeck();
        deck.buildDeck(sampleDeck.size(), sampleDeck);
        sampleCard newCard = (sampleCard) deck.drawCard(deck);
        assertTrue(newCard.cardValue == 7);

    }

    @Test
    void isDeckEmpty() {
        ArrayList<sampleCard> sampleDeck = new ArrayList<sampleCard>();
        cardDeck deck = new cardDeck();
        deck.buildDeck(sampleDeck.size(), sampleDeck);
        assertTrue(deck.isDeckEmpty());
    }

    @Test
    void shuffle() {

    }
}
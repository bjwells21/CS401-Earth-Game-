package earthGame.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class cardPultest<T> {

    @Test
    void buildDeck() {
        ArrayList<IslandCard> sampleDeck = new ArrayList<IslandCard>();
        IslandCard newCard = new IslandCard("TAHITI");
        sampleDeck.add(newCard);
        newCard = new IslandCard("MAUI");
        sampleDeck.add(newCard);

        System.out.println("size of sample deck is:" + sampleDeck.size());
        cardDeck newDeck = new cardDeck();
        newDeck.buildDeck(sampleDeck.size(),sampleDeck);
        assertEquals(2, newDeck.returnDeckSize());          //test for deck size

        newCard = (IslandCard) newDeck.drawCard(newDeck);           //draws a card
        assertTrue(newCard.getVictoryPoints() == 3);        //checks if first card is as expected

        System.out.println("size of newDeck is:" + newDeck.returnDeckSize());
        System.out.println("now printing the contents of cardDeck");
        for(int i = 0; i < newDeck.returnDeckSize(); i++){
            System.out.println(newDeck.drawCard(newDeck));
        }


    }
}
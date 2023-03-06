package earthGame;
import java.util.ArrayList;
import java.util.Collections;

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

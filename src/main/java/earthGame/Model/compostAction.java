package earthGame.Model;

public class compostAction {
    public void compost(Player player, cardDeck deck, cardDeck discard, int choice){
        if (player.isActivePlayer()){
            discard.cards.add(deck.drawCard());
            player.addCompost(2);
            player.addSoil(5);
        } else {
            if (choice == 1) {
                player.addCompost(2);
            } else {
                player.addSoil(2);
            }
        }
    }

}

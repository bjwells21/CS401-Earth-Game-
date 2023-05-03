package earthGame.Model;

public class growthAction {
    public void growth(Player player, int choice, cardDeck deck){
        if (player.isActivePlayer()){
            player.drawFromDeck(deck);
            player.drawFromDeck(deck);
            player.drawFromDeck(deck);
            player.drawFromDeck(deck);
            player.addGrowth(2);
        } else {
            if (choice == 1){
                player.drawFromDeck(deck);
                player.drawFromDeck(deck);
            } else {
                player.addGrowth(2);
            }
        }
    }
}

package earthGame.Model;

public class waterAction {
    public void water(Player player, int choice){
        if (player.isActivePlayer()){
            player.addSoil(2);
            player.addSprouts(6);
        } else {
            if (choice == 1){
                player.addSprouts(6);
            } else {
                player.addSoil(2);
            }
        }
    }
}

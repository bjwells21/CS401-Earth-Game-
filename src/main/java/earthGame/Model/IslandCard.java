package earthGame.Model;

import java.util.Random;

//Enum for the names of each Island Card
enum Islands {
    MAUI,
    MAJORCA,
    LUZON,
    KYUSHU,
    TENERIFE,
    TAHITI
}

public class IslandCard extends Card {
    //each card has a certain amount of victory points awarded at the end of the game
    //Each card also has a color associated with it that can be activated at each player's turn
    private int victoryPoints;
    private String abilityColor;
    private Islands i;

    //default constructor
    public IslandCard(){
        victoryPoints = 0;
        abilityColor = "";
    }

    /**
     * Initializes an Island Card based on the given name
     * @param name - Name of the card based of the Islands enum
     */
    public IslandCard(String name){
        i = Islands.valueOf(name);
        switch (i) {
            case MAUI -> {
                victoryPoints = 1;
                abilityColor = "GREEN";
            }
            case MAJORCA -> {
                victoryPoints = 2;
                abilityColor = "RED";
            }
            case LUZON -> {
                victoryPoints = 2;
                abilityColor = "BLUE";
            }
            case KYUSHU -> {
                victoryPoints = 3;
                abilityColor = "YELLOW";
            }
            case TENERIFE -> {
                victoryPoints = 2;
                abilityColor = "MULTI";
            }
            case TAHITI -> {
                victoryPoints = 3;
                abilityColor = "BLUE";
            }
            default -> {
            }
        }
    }


    /**
     * Activates the cards initial ability and provides player with starting materials
     * @param player - The current player who possesses the Island Card to activate the effect
     */
    public void initialEffect(Player player){
        switch(i){
            case MAUI:
            case MAJORCA:
            case LUZON:
                //add certain amount of soil to the player
                //draw a certain number of cards for the player
                //Compost a certain number of cards
                player.addSoil(6);
                //player.addToHand(4);
                player.addCompost(2);
                break;
            case KYUSHU:
            case TENERIFE:
            case TAHITI:
                //noinspection DuplicateBranchesInSwitch
                player.addSoil(4);
                //player.addToHand(6);
                player.addCompost(3);
                break;
            default:
                break;
        }
    }

    /**
     * Activates the cards ability based on the color of the ability and updates the players values
     * @param player - The current player who possesses the Island Card to activate the ability
     */
    //User Story: As a player when I activate my card's ability, I want the respective ability to activate and do its functionality
    public void abilityEffect(Player player){
        switch (this.abilityColor) {
            case "BLUE" -> {
                //add growth pieces to the player to be added in the future
                //draw a certain number of cards for the player or compost a certain number of cards
                //player.addToHand(2);
                player.addSoil(5);
            }
            case "GREEN" -> {
                //player.addToHand(4);
                player.addSoil(3);
            }
            //noinspection DuplicateBranchesInSwitch
            case "RED" -> {
                //player.addToHand(2);
                player.addSoil(7);
            }
            case "YELLOW" -> {
                //player.addToHand(5);
                player.addSoil(5);
            }
            case "MULTI" -> {
                //player.addToHand(3);
                player.addSoil(3);
            }
            default -> {
            }
        }
    }


    /**
     * Overriden method to pass output of the card to view
     * @return Formatted String output of card's info
     */
    @Override
    public String toString(){
        return "Island card: \nName: " + i.name() + "\nVictory Points: " + getVictoryPoints() +
                "\nAbility's Color: " + getAbilityColor() + "\n";
    }

    //getters and setters
    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public String getAbilityColor() {
        return abilityColor;
    }

    public void setAbilityColor(String abilityColor) {
        this.abilityColor = abilityColor;
    }

    public Islands getName(){ return i; }
}

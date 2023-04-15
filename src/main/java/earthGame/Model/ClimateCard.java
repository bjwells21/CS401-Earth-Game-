package earthGame.Model;

import earthGame.Model.Card;

import java.util.Random;

//Enum for the names of each Climate Card
enum Climate {
    TROPICAL,
    DRY,
    TEMPERATE,
    CONTINENTAL,
    POLAR
}

public class ClimateCard extends Card {
    //each card has a certain amount of victory points awarded at the end of the game
    private int victoryPoints;
    //the enum will act as the name of card and be used to identify abilities
    private Climate c;
    private String abilityColor;

    //default constructor
    public ClimateCard(){
        victoryPoints = 0;
        abilityColor = "";
    }

    /**
     * Initializes a Climate Card based on the given name
     * @param name - Name of the card based of the Climate enum
     */
    public ClimateCard(String name){
        //convert the string to enum typ
        c = Climate.valueOf(name);
        //use a switch case to assign the cards respective victory points
        switch(c){
            case TROPICAL -> {
                victoryPoints = 1;
                abilityColor = "GREEN";
            }
            case DRY -> {
                victoryPoints = 2;
                abilityColor = "RED";
            }
            case TEMPERATE -> {
                victoryPoints = 3;
                abilityColor = "BLUE";
            }
            case CONTINENTAL -> {
                victoryPoints = 4;
                abilityColor = "YELLOW";
            }
            case POLAR -> {
                victoryPoints = 5;
                abilityColor = "MULTI";
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
        return "Climate card: \nName: " + c.name() + "\nVictory Points: " + getVictoryPoints() + "\n";
    }

    /**
     * Activates the cards ability based on the color of the ability and updates the players values
     * @param player - The current player who possesses the Climate Card to activate the ability
     */
    //User Story: As a player when I activate my card's ability, I want the respective ability to activate and do its functionality
    public void abilityEffect(Player player){
        switch(abilityColor){
            case "BLUE" -> {
                player.addSoil(3);
            }
            case "GREEN" -> {
                player.addSoil(4);
            }
            case "RED" -> {
                player.addSoil(1);
            }
            case "YELLOW" -> {
                player.addSoil(2);
            }
            case "MULTI" -> {
                player.addSoil(5);
            }
            default -> {
            }
        }
    }

    //getters and setters
    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public Climate getC() {
        return c;
    }

    public void setC(Climate c) {
        this.c = c;
    }

    public String getAbilityColor() {
        return abilityColor;
    }

    public void setAbilityColor(String abilityColor) {
        this.abilityColor = abilityColor;
    }
}

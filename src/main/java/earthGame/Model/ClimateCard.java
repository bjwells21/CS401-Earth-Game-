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

    //function used to draw a random card from all Climate cards
    //Used by the player class in assigning each user their beginning climate card
    //currently allows for duplicates will need to be fixed in the future

    //User Story: As a player I want to be able to draw a random Climate card to setup my game
    public static ClimateCard randomDrawCard(){
        //get a random enum and return an object initialized with that name card
        Climate tmp = Climate.values()[new Random().nextInt(Climate.values().length)];
        return new ClimateCard(tmp.name());
    }

    //Overridden toString() method to output the cards description
    @Override
    public String toString(){
        return "Climate card: \nName: " + c.name() + "\nVictory Points: " + getVictoryPoints() + "\n";
    }

    //function used to activate the card's victory point count implemented through a switch case that matches with the card's name
    //victory points are added to the player's count

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

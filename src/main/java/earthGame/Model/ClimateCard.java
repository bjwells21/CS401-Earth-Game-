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

    //default constructor
    public ClimateCard(){
        victoryPoints = 0;
    }


    public ClimateCard(String name){
        //convert the string to enum type
        c = Climate.valueOf(name);
        //use a switch case to assign the cards respective victory points
        switch(c){
            case TROPICAL -> {
                victoryPoints = 1;
            }
            case DRY -> {
                victoryPoints = 2;
            }
            case TEMPERATE -> {
                victoryPoints = 3;
            }
            case CONTINENTAL -> {
                victoryPoints = 4;
            }
            case POLAR -> {
                victoryPoints = 5;
            }
            default -> {
            }
        }
    }

    //function used to draw a random card from all Climate cards
    //Used by the player class in assigning each user their beginning climate card
    //currently allows for duplicates will need to be fixed in the future
    public static ClimateCard randomDrawCard(){
        //get a random enum and return an object initialized with that name card

    public static ClimateCard randomDrawCard(){
        Climate tmp = Climate.values()[new Random().nextInt(Climate.values().length)];
        return new ClimateCard(tmp.name());
    }

    //Overridden toString() method to output the cards description
    @Override
    public String toString(){
        return "Climate card: \nName: " + c.name() + "\nVictory Points: " + Integer.toString(getVictoryPoints()) + "\n";
    }

    //function used to activate the card's ability implemented through a switch case that matches with the card's name
    //needs to have interaction with the player class to be implemented in future
    //return an int to player class which can then call the player objects addSoil() method
    public int abilityEffect(){
        switch(c){
            case TROPICAL -> {
                return 3;
            }
            case DRY -> {
                return 4;
            }
            case TEMPERATE -> {
                return 1;
            }
            case CONTINENTAL, POLAR -> {
                return 2;
            }
            default -> {
                return 0;
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
}

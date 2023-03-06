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


    //constructor that takes string argument and creates card object based on name
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

    //This function is for the initial ability to get player setup with material
    //Needs to be implemented in the future interacting with player and deck classes
    public void initialEffect(){
        switch(i){
            case MAUI:
            case MAJORCA:
            case LUZON:
                //add certain amount of soil to the player
                //draw a certain number of cards for the player
                //Compost a certain number of cards
                break;
            case KYUSHU:
            case TENERIFE:
            case TAHITI:
                //add certain amount of soil to the player
                //draw a certain number of cards for the player
                //Compost a certain number of cards
                //noinspection DuplicateBranchesInSwitch
                break;
            default:
                break;
        }
    }

    //The ability effect for Island cards provide players with material
    //Future implementation would interact with player class possibly through a return value
    //which controller could call player class's methods
    public void abilityEffect(){
        switch(i){
            case MAUI:
            case MAJORCA:
            case LUZON:
                //add growth pieces to the player
                //draw a certain number of cards for the player or compost a certain number of cards
                //add soil to the player
                break;
            case KYUSHU:
            case TENERIFE:
            case TAHITI:
                //add growth pieces to the player
                //draw a certain number of cards for the player or compost a certain number of cards
                //add soil to the player
                //noinspection DuplicateBranchesInSwitch
                break;
            default:
                break;
        }
    }

    //function used to draw a random card from all Island cards
    //Used by the player class in assigning each user their beginning Island card
    //currently allows for duplicates will need to be fixed in the future
    public static IslandCard randomDrawCard(){
        Islands tmp = Islands.values()[new Random().nextInt(Islands.values().length)];
        return new IslandCard(tmp.name());
    }

    //Overridden toString() method to output the cards description
    @Override
    public String toString(){
        return "Island card: \nName: " + i.name() + "\nVictory Points: " + Integer.toString(getVictoryPoints()) +
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
}

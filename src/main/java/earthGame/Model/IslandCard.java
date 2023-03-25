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
    public void initialEffect(Player player){
        switch(i){
            case MAUI:
            case MAJORCA:
            case LUZON:
                //add certain amount of soil to the player
                //draw a certain number of cards for the player
                //Compost a certain number of cards
                player.addSoil(6);
                player.addToHand(4);
                player.addCompost(2);
                break;
            case KYUSHU:
            case TENERIFE:
            case TAHITI:
                //add certain amount of soil to the player
                //draw a certain number of cards for the player
                //Compost a certain number of cards
                //noinspection DuplicateBranchesInSwitch
                player.addSoil(4);
                player.addToHand(6);
                player.addCompost(3);
                break;
            default:
                break;
        }
    }

    //The ability effect for Island cards provide players with material
    public void abilityEffect(Player player){
        switch (this.abilityColor) {
            case "BLUE" -> {
                //add growth pieces to the player to be added in the future
                //draw a certain number of cards for the player or compost a certain number of cards
                //add soil to the player
                player.addToHand(2);
                player.addSoil(5);
            }
            case "GREEN" -> {
                player.addToHand(4);
                player.addSoil(3);
            }
            //noinspection DuplicateBranchesInSwitch
            case "RED" -> {
                player.addToHand(2);
                player.addSoil(7);
            }
            case "YELLOW" -> {
                player.addToHand(5);
                player.addSoil(5);
            }
            case "MULTI" -> {
                player.addToHand(3);
                player.addSoil(3);
            }
            default -> {
            }
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
}

package earthGame.Model;

import earthGame.Model.Card;

import java.util.Random;

enum Climate {
    TROPICAL,
    DRY,
    TEMPERATE,
    CONTINENTAL,
    POLAR
}

public class ClimateCard extends Card {
    private int victoryPoints;
    private Climate c;

    public ClimateCard(){
        victoryPoints = 0;
    }
    public ClimateCard(String name){
        c = Climate.valueOf(name);
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

    public static ClimateCard randomDrawCard(){
        Climate tmp = Climate.values()[new Random().nextInt(Climate.values().length)];
        return new ClimateCard(tmp.name());
    }

    public String toString(){
        return "Climate card: \nName: " + c.name() + "\nVictory Points: " + Integer.toString(getVictoryPoints()) + "\n";
    }

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

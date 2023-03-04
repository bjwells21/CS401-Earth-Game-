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
        }
    }

    public ClimateCard randomDrawCard(){
        Climate tmp = Climate.values()[new Random().nextInt(Climate.values().length)];
        return new ClimateCard(tmp.name());
    }

    public void abilityEffect(){

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

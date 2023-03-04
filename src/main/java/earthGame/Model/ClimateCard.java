package earthGame.Model;

import earthGame.Model.Card;

enum Climate {
    TROPICAL,
    DRY,
    TEMPERATE,
    CONTINENTAL,
    POLAR
}

public class ClimateCard extends Card {
    private int victoryPoints;

    public ClimateCard(){
        victoryPoints = 0;
    }
    public ClimateCard(int victoryPoints){
        this.victoryPoints = victoryPoints;
    }

    public void abilityEffect(){

    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(int victoryPoints) {
        this.victoryPoints = victoryPoints;
    }
}

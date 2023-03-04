package earthGame;

enum Islands {
    MAUI,
    MAJORCA,
    LUZON,
    KYUSHU,
    TENERIFE,
    TAHITI
}

public class IslandCard extends Card{
    private int victoryPoints;
    private String abilityColor;
    private Islands i;

    public IslandCard(){
        victoryPoints = 0;
        abilityColor = "";
    }
    public IslandCard(int victoryPoints, String abilityColor, String name){
        this.victoryPoints = victoryPoints;
        this.abilityColor = abilityColor;
        i = Islands.valueOf(name);
    }
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

    public String toString(){
        return "Island card: \nName: " + i.name() + "\nVictory Points: " + Integer.toString(getVictoryPoints()) +
                "\nAbility's Color: " + getAbilityColor() + "\n";
    }

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

package earthGame.Model;

//Enum for the names of each Terrain Card
enum Terrains {
    PLATEAU,
    MOUNTAIN,
    PLAINS,
    VALLEYS,
    CANYONS,
    KARSTS,
    CIRQUES,
    FOOTHILLS,
    PLAYAS,
    DUNES,
    MOUNDS,
    BUTTE,
    MESA,
    MARSH,
    GLACIER
}

public class Terrain extends Card {

    //victory points should be added to players total in the end
    //Soil should be an attribute of the player class instead of a variable in a card class
    private int victoryPoints;
    private int soil;
    private Terrains t;
    private String abilityColor;

    public Terrain(){
        victoryPoints = 0;
        soil = 0;
        abilityColor = "";
    }

    public Terrain(String name){
        //Convert String to enum type
        t = Terrains.valueOf(name);
        switch(t){
            case PLATEAU -> {
                victoryPoints = 1;
                soil = 5;
                abilityColor = "GREEN";
            }
            case MOUNTAIN -> {
                victoryPoints = 2;
                soil = 6;
                abilityColor = "RED";
            }
            case PLAINS -> {
                victoryPoints = 3;
                soil = 1;
                abilityColor = "BLUE";
            }
            case VALLEYS -> {
                victoryPoints = 4;
                soil = 4;
                abilityColor = "YELLOW";
            }
            case CANYONS -> {
                victoryPoints = 5;
                soil = 3;
                abilityColor = "MULTI";
            }
            case KARSTS -> {
                victoryPoints = 5;
                soil = 3;
                abilityColor = "GREEN";
            }
            case CIRQUES -> {
                victoryPoints = 5;
                soil = 3;
                abilityColor = "RED";
            }
            case FOOTHILLS -> {
                victoryPoints = 6;
                soil = 2;
                abilityColor = "BLUE";
            }
            case PLAYAS -> {
                victoryPoints = 6;
                soil = 2;
                abilityColor = "YELLOW";
            }
            case DUNES -> {
                victoryPoints = 6;
                soil = 2;
                abilityColor = "MULTI";
            }
            case MOUNDS -> {
                victoryPoints = 6;
                soil = 2;
                abilityColor = "GREEN";
            }
            case BUTTE -> {
                victoryPoints = 6;
                soil = 2;
                abilityColor = "RED";
            }
            case MESA -> {
                victoryPoints = 2;
                soil = 6;
                abilityColor = "MULTI";
            }
            case MARSH -> {
                victoryPoints = 2;
                soil = 6;
                abilityColor = "GREEN";
            }
            case GLACIER -> {
                victoryPoints = 2;
                soil = 6;
                abilityColor = "YELLOW";
            }
            default -> {
            }
        }
    }

    //Each Terrain card has an endgame effect that adds victoryPoints to each player
    public void endgameEffect(Player player){
        player.addPoints(this.victoryPoints);
    }

    //Each card also has a directional ability effect
    public void directionalAbilityEffect(Player player){
        player.addSoil(this.soil);
    }

    //Overridden toString() method to output the cards description
    @Override
    public String toString(){
        return "Terrain card: \nName: " + t.name() + "\nVictory Points: " + getVictoryPoints() +
                "\nSoil Value: " + getSoilValue() + "Ability's Color: " + getAbilityColor() + "\n";
    }

    //getters and setters
    public String getAbilityColor() {
        return abilityColor;
    }
    public int getSoilValue(){
        return soil;
    }
    public int getVictoryPoints(){
        return victoryPoints;
    }
    public String getCardName(){
        return t.name();
    }

    public void setAbilityColor(String abilityColor) {
        this.abilityColor = abilityColor;
    }
    public void setSoilValue(int soil){
        this.soil = soil;
    }
    public void setVictoryPoints(int victoryPoints){
        this.victoryPoints = victoryPoints;
    }
    public void setCardName(String name){
        t = Terrains.valueOf(name);
    }
}

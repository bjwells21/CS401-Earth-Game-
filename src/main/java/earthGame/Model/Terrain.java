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

public class Terrain {

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

    public Terrain(int victoryPoints, int soil, String name, String abilityColor){
        this.victoryPoints = victoryPoints;
        this.soil = soil;
        //Convert String to enum type
        Terrains t = Terrains.valueOf(name);
        this.abilityColor = abilityColor;
    }

    //Each Terrain card has an endgame effect that adds victoryPoints to each player
    //Could change implementation so that returns the associated victory point to controller
    public void endgameEffect(){
        switch (t) {
            case PLATEAU -> victoryPoints = victoryPoints + 1;
            case MOUNTAIN, MESA, MARSH, GLACIER -> victoryPoints = victoryPoints + 2;
            case PLAINS -> victoryPoints = victoryPoints + 3;
            case VALLEYS -> victoryPoints = victoryPoints + 4;
            case CANYONS, KARSTS, CIRQUES -> victoryPoints = victoryPoints + 5;
            case FOOTHILLS, PLAYAS, DUNES, MOUNDS, BUTTE -> victoryPoints = victoryPoints + 6;
            default -> {
            }
        }
    }

    //Each card also has a directional ability effect that could be imporved on by abstracting functionality
    //to the controller
    public void directionalAbilityEffect(){
        switch(t) {
            case PLATEAU -> soil = soil + 1;
            case MOUNTAIN, MESA, MARSH, GLACIER -> soil = soil + 2;
            case PLAINS -> soil = soil + 3;
            case VALLEYS -> soil = soil + 4;
            case CANYONS, KARSTS, CIRQUES -> soil = soil + 5;
            case FOOTHILLS, PLAYAS, DUNES, MOUNDS, BUTTE -> soil = soil + 6;
            default -> {
            }
        }
    }

    //Overridden toString() method to output the cards description
    @Override
    public String toString(){
        return "Terrain card: \nName: " + t.name() + "\nVictory Points: " + Integer.toString(getVictoryPoints()) +
                "\nSoil Value: " + Integer.toString(getSoilValue()) + "Ability's Color: " + getAbilityColor() + "\n";
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

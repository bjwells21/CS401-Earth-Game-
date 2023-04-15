package earthGame.Model;

import java.util.Objects;

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

    /**
     * Initializes a Terrain Card based on the given name
     * @param name - Name of the card based of the Terrains enum
     */
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


    /**
     * Activates the cards endgame ability and provides player with ending points
     * @param player - The current player who possesses the Island Card to activate the effect
     */
    //User Story: When the endgame is triggered, I as the user want to be able to tally up my card's victory points to my count
    public void endgameEffect(Player player){
        int[] index = getCardPosition(player);

        Class c1 = player.tableau[index[0]][index[1]].getClass();
        Class c2 = this.getClass();

        switch(t){
            case PLATEAU, MOUNTAIN, PLAINS -> {
                for(int i = 0; i < 4; i++){
                    if(player.tableau[index[0]][i].getClass() == c2){
                        player.addPoints(2);
                    }
                }
            }
            case VALLEYS, CANYONS, KARSTS -> {
                for(int i = 0; i < 4; i++){
                    if(player.tableau[i][index[0]].getClass() == c2){
                        player.addPoints(3);
                    }
                }
            }
            case CIRQUES, FOOTHILLS, PLAYAS -> {
                for(int i = 0; i < 4; i++){
                    if(player.tableau[i][index[0]].getClass() == c2){
                        player.addPoints(2);
                    }
                }
            }
            case DUNES, MOUNDS, BUTTE -> {
                for(int i = 0; i < 4; i++){
                    if(player.tableau[index[0]][i].getClass() == c2){
                        player.addPoints(3);
                    }
                }
            }
            case MESA, MARSH, GLACIER -> {
                player.addPoints(4);
            }
            default -> {

            }
        }
    }

    /**
     * Activates the cards ability and provides player with resources based on the ability color
     * @param player - The current player who possesses the Island Card to activate the effect
     */
    //As a user when I activate my card's ability, I want it to activate my ability and do its functionality
    public void directionalAbilityEffect(Player player){
        switch(abilityColor){
            case "RED" -> {
                player.addSoil(3);
            }
            case "BLUE" -> {
                player.addSoil(2);

            }
            case "GREEN" -> {
                player.addSoil(4);
            }
            case "YELLOW" -> {
                player.addSoil(5);
            }
            case "MULTI" -> {
                player.addSoil(1);
            }
            default -> {

            }
        }
    }

    /**
     * Overriden method to pass output of the card to view
     * @return Formatted String output of card's info
     */
    @Override
    public String toString(){
        return "Terrain card: \nName: " + t.name() + "\nVictory Points: " + getVictoryPoints() +
                "\nSoil Value: " + getSoilValue() + "Ability's Color: " + getAbilityColor() + "\n";
    }

    /**
     * Checks to see if two Terrain cards are the same or not
     * @param obj - The object that we want to compare to
     * @return True if the object is a Terrain object and the exact same card. False if otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Terrain t){
            return this.victoryPoints == t.victoryPoints && Objects.equals(this.abilityColor, t.abilityColor) &&
                    this.soil == t.soil && this.t == t.t;
        }
        return false;

    }

    /**
     * Find the index of where the card is positioned in the 4x4 tableau
     * @param player - The current player who possesses the Island Card to activate the ability
     * @return The row and column index numbers of where the card is located
     */
    public int[] getCardPosition(Player player){
        int[] index = new int[2];
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++){
                if(player.tableau[i][j].equals(this)){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        return null;
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

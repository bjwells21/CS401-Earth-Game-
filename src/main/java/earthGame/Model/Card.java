package earthGame.Model;

import java.util.ArrayList;

//Common elements between all cards
//Mainly used to act as a parent class in creation of the tableau
//and hold a list of attributes to be implemented in the future
class Card {
    public String name;
    public String subName;
    public ArrayList<String> habitatElements = new ArrayList<String>();
}

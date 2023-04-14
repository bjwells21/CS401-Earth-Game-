package earthGame;
import earthGame.Controller.*;
import earthGame.Model.*;
import earthGame.View.*;

public class Driver {
    public static void main(String[] args){
        System.out.println("Welcome to the Earth Game");
        //this class simply instantiates the board space and the number of players.
        int numPlayers = 2;
        gameRules newGame = new gameRules(numPlayers);
    }
}

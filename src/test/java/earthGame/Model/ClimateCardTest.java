package earthGame.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClimateCardTest{
    Player p1;
    ClimateCard c;

    @BeforeEach
    public void init(){
        p1 = new Player(50, 1);
        c = new ClimateCard("CONTINENTAL");
    }

    @Test
    public void abilityEffectTest(){
        c.abilityEffect(p1);
        assertEquals(p1.getSoil(), 52);
    }

    @Test
    public void testToString(){
        ClimateCard randomCard = ClimateCard.randomDrawCard();
        String info = "Climate card: \nName: " + randomCard.getC() + "\nVictory Points: " + randomCard.getVictoryPoints() + "\n";
        assertEquals(info, randomCard.toString());
    }
}
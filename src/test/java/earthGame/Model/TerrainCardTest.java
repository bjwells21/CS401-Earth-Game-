package earthGame.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TerrainCardTest {
    Player p1;
    Terrain t;

    @BeforeEach
    public void init(){
        p1 = new Player(50,1);
        t = new Terrain("PLAINS");
    }

    @Test
    public void abilityEffectTest(){
        t.directionalAbilityEffect(p1);
        assertEquals(p1.getSoil(), 51);
    }

    @Test
    public void endgameEffectTest(){
        t.endgameEffect(p1);
        assertEquals(p1.getPoints(), 3);
    }

    @Test
    public void testToString(){
        String info = "Terrain card: \nName: " + t.getCardName() + "\nVictory Points: " + t.getVictoryPoints() +
                "\nSoil Value: " + t.getSoilValue() + "Ability's Color: " + t.getAbilityColor() + "\n";

        assertEquals(t.toString(), info);
    }
}

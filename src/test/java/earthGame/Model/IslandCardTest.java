package earthGame.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IslandCardTest {
    Player p1;
    IslandCard i;

    @BeforeEach
    public void init(){
        p1 = new Player(50, 1);
        i = new IslandCard("MAUI");
    }

    @Test
    public void initialEffectTest(){
        i.initialEffect(p1);
        assertEquals(p1.getSoil(), 56);
        assertEquals(p1.getCompost(), 2);
    }

    @Test
    public void testToString(){
        IslandCard randomCard = cardDeck.randomDrawIslandCard();
        String info = "Island card: \nName: " + randomCard.getName() + "\nVictory Points: " + randomCard.getVictoryPoints() + "\nAbility's Color: " + randomCard.getAbilityColor() + "\n";
        assertEquals(info, randomCard.toString());
    }
}

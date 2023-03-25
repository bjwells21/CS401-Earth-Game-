package earthGame.Model;

import earthGame.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player p1;
    IslandCard c;
    @BeforeEach
    public void init() {
        p1 = new Player(50, 1);
        c = new IslandCard("MAUI");
    }
    @Test
    public void addCompostTest(){
        p1.addCompost(50);
        assertEquals (p1.getCompost(), 50);
    }

    @Test
    public void negCompostTest(){
        p1.addCompost(1);
        p1.addCompost(-2);
        assertTrue (p1.getCompost() > 0);
    }

    @Test
    public void addPointsTest(){
        p1.addPoints(100);
        assertEquals(p1.getPoints(),100);
    }
    @Test
    public void negPointsTest(){
        p1.addPoints(1);
        p1.addPoints(-2);
        assertTrue(p1.getPoints() > 0);
    }
    @Test
    public void addSoilTest(){
        p1.addSoil(50);
        assertEquals(p1.getSoil(),100);
    }
    @Test
    public void negSoilTest(){
        p1.addSoil(-51);
        assertTrue(p1.getSoil() > 0);
    }
    @Test
    public void addToHandTest(){
        p1.addToHand(c);
        assertEquals(p1.getCardFromHand(0), c);
    }
    @Test
    public void removeFromHandTest(){
        p1.addToHand(c);
        p1.removeCard(c);
        assertEquals(p1.getHandSize(), 0);
    }
    @Test
    public void addToTableauTest(){
        p1.addToTableau(c,0,1);
        assertEquals(p1.tableau[0][1],c);
    }

    @Test
    public void viewPlayerInfoTest(){
        String viewInfo = p1.toString();
        String s = "Player " + p1.getPlayerNumber() + ":\n-----------\n"
                + "Compost: " + p1.getCompost() + "\n"
                + "Soil: " + p1.getSoil() + "\n"
                + "VPoints: " + p1.getPoints() + "\n";
        assertEquals(s,viewInfo);
    }
    @Test
    public void viewHandTest(){
        p1.addToHand(c);
        String viewHand = p1.viewHand();
        String s = c.toString() + "\n";
        assertEquals(viewHand, s);
    }

    @Test
    public void isTableauEmpty(){
        assertFalse(p1.isTableauFull());
    }

    @Test
    public void isTableauFullTest(){
        for (int i = 0; i<p1.getTableau().length;i++){
            for (int j = 0; j<p1.getTableau()[i].length;j++)
                p1.addToTableau(c,i,j);
        }
        assertTrue(p1.isTableauFull());
    }
}
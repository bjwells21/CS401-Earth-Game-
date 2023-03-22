import earthGame.Model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player p1;
    @BeforeEach
    public void init() {
        p1 = new Player(50, 1);
    }
    @Test
    public void addCompostTest(){
        p1.addCompost(50);
        assertEquals (p1.compost, 50);
    }

    @Test
    public void negCompostTest(){
        p1.addCompost(1);
        p1.addCompost(-2);
        assertTrue (p1.compost > 0);
    }

    @Test
    public void addPointsTest(){
        p1.addPoints(100);
        assertEquals(p1.totalVPoints,100);
    }
    @Test
    public void negPointsTest(){
        p1.addPoints(1);
        p1.addPoints(-2);
        assertTrue(p1.totalVPoints > 0);
    }
    @Test
    public void addSoilTest(){
        p1.addSoil(50);
        assertEquals(p1.soil,100);
    }
    @Test
    public void negSoilTest(){
        p1.addSoil(-51);
        assertTrue(p1.soil > 0);
    }
    /*@Test
    public void addToHandTest(){
        p1.addToHand(1);
        assertEquals(p1.hand.size(), 1);
    }
     */
}
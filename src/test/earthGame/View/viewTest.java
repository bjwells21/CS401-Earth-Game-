package earthGame.View;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class viewTest {
    @Test
    public void gameQuitSuccessful(){
        String userInput = String.format("Q");
        ByteArrayInputStream quit = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(quit);

        String expected = "false";
        ByteArrayOutputStream q = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(q);
        System.setOut(printStream);
        view.main(null);
        String actual = q.toString();
        assertFalse(Boolean.parseBoolean(expected),actual);
    }

    @Test
    public void gameStartSuccessful(){
        String userInput = String.format("C\n1");
        ByteArrayInputStream start = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(start);

        String expected = "true";
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(s);
        System.setOut(printStream);
        view.main(null);
        String actual = s.toString();
        assertTrue(Boolean.parseBoolean(expected),actual);
    }
}
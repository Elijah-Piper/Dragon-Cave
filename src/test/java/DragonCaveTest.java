import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

class DragonCaveTest {

    @Test
    void randomIntOneOrTwoShouldReturnOneOrTwo() {
        // Tests 10 times, asserting the method always gives either 1 or 2
        int randInt;

        for (int i = 0; i < 10; i++) {
            randInt = DragonCave.randomIntOneOrTwo();
            assertTrue(
                    randInt == 1 || randInt == 2,
                    "randomIntOneOrTwo method in DragonCave class returned %d."
                            .formatted(randInt));
        }
    }

    @Test
    void getUserChoiceStringInputDoesNotThrowInputMismatchException() {
        String invalidStr = "invalid input";
        String validStr = "1";
        InputStream invalidInput = new ByteArrayInputStream(invalidStr.getBytes());
        InputStream validInput = new ByteArrayInputStream(validStr.getBytes());

        System.setIn(invalidInput);
        try {
            int result = DragonCave.getUserChoice();
        } catch (NoSuchElementException e) {
            System.setIn(validInput);
            int result = DragonCave.getUserChoice();
        }

    }

    @Test
    void getUserChoiceReturnsOne() {
        String inStr = "1";
        InputStream input = new ByteArrayInputStream(inStr.getBytes());

        System.setIn(input);
        int result = DragonCave.getUserChoice();

        assertEquals(1, result);
    }

    @Test
    void getUserChoiceReturnsTwo() {
        String inStr = "2";
        InputStream input = new ByteArrayInputStream(inStr.getBytes());

        System.setIn(input);
        int result = DragonCave.getUserChoice();

        assertEquals(2, result);
    }
}
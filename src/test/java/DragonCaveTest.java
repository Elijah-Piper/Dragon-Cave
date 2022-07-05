import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
}
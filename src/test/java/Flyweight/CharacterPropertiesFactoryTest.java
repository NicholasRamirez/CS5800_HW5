package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {

    @Test
    void getCharacterPropertiesAndCachesTest() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties a = factory.getCharacterProperties("Arial", 12, "Red");
        CharacterProperties b = factory.getCharacterProperties("Arial", 12, "Red");

        assertSame(a, b);
        assertEquals(1, factory.cacheSize());
    }
}

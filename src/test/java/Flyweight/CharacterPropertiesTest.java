package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesTest {

    @Test
    void getterTest() {
        CharacterProperties properties = new CharacterProperties("Arial", 12, "Red");
        assertEquals("Arial", properties.getFont());
        assertEquals(12, properties.getSize());
        assertEquals("Red", properties.getColor());
    }

    @Test
    void equalsAndHashTest() {
        CharacterProperties a = new CharacterProperties("Arial", 12, "Red");
        CharacterProperties b = new CharacterProperties("Arial", 12, "Red");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}

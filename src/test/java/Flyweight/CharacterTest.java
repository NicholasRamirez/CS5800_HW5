package Flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    void getterAndSetterTest() {
        CharacterProperties properties = new CharacterProperties("Arial", 12, "Red");
        Character character = new Character('H', properties);

        assertEquals('H', character.getCharacter());
        assertEquals(properties, character.getProperties());

        character.setCharacter('E');
        assertEquals('E', character.getCharacter());
    }
}

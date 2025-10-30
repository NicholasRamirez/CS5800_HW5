package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {

    private final Map<String, CharacterProperties> cache = new HashMap<>();

    private static String characterKey(String font, int size, String color) {
        return font + "|" + size + "|" + color;
    }

    public CharacterProperties getCharacterProperties(String font, int size, String color) {
        String key = characterKey(font, size, color);
        if (!cache.containsKey(key)) {
            cache.put(key, new CharacterProperties(font, size, color));
        }
        return cache.get(key);
    }

    public int cacheSize() {
        return cache.size();
    }
}
package Flyweight;

import java.util.Objects;

public class CharacterProperties {

    private final String font;
    private final int size;
    private final String color;

    CharacterProperties(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CharacterProperties)) return false;
        CharacterProperties charProp = (CharacterProperties) obj;
        return size == charProp.size &&
                Objects.equals(font, charProp.font) &&
                Objects.equals(color, charProp.color);
    }

    @Override
    public String toString() {
        return String.format("Font: %s, Color: %s, Size: %d", font, color, size);
    }

    @Override public int hashCode() {
        return Objects.hash(font, color, size);
    }
}
package Flyweight;

public class Character {

    private char character;
    private CharacterProperties properties;

    public Character(char character, CharacterProperties properties) {
        this.character = character;
        this.properties = properties;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    public void setProperties(CharacterProperties properties) {
        this.properties = properties;
    }
}
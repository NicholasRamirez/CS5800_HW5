package Flyweight;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Documents {

    private final List<Character> characters = new ArrayList<>();
    private final CharacterPropertiesFactory factory;

    public Documents(CharacterPropertiesFactory factory) {
        this.factory = factory;
    }

    public void appendText(char character, String font, int size, String color) {
        characters.add(new Character(character, factory.getCharacterProperties(font, size, color)));
    }

    public int length() {
        return characters.size();
    }

    public Character getCharacter(int index) {
        return characters.get(index);
    }

    public String getPlainText() {
        StringBuilder stringBuild = new StringBuilder(characters.size());
        for (Character character : characters)
            stringBuild.append(character.getCharacter());
        return stringBuild.toString();
    }

    public void saveFile(Path path) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (int i = 0; i < characters.size(); i++) {
                Character character = characters.get(i);
                CharacterProperties properties = character.getProperties();

                writer.write(i + "\t" + character.getCharacter() + "\t" +
                        properties.getFont() + "\t" +
                        properties.getSize() + "\t" +
                        properties.getColor());
                writer.newLine();
            }
        }
    }

    public static Documents load(Path path, CharacterPropertiesFactory factory) throws IOException {
        Documents doc = new Documents(factory);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String line : lines) {
            String[] parts = line.split("\\t");
            if (parts.length != 5) continue; // skip malformed lines

            char ch = parts[1].charAt(0);
            String font = parts[2];
            int size = Integer.parseInt(parts[3]);
            String color = parts[4];

            doc.appendText(ch, font, size, color);
        }

        return doc;
    }
}
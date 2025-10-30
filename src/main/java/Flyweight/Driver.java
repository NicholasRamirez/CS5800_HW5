package Flyweight;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {
    public static void main(String[] args) throws Exception {

        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Documents doc = new Documents(factory);

        String text = "HelloWorldCS5800";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (i <= 4) {
                // Hello
                doc.appendText(c, "Arial", 12, "Red");
            } else if (i <= 9) {
                // World
                doc.appendText(c, "Calibri", 14, "Blue");
            } else if (i <= 11) {
                // CS
                doc.appendText(c, "Verdana", 16, "Black");
            } else {
                // 5800
                doc.appendText(c, "Arial", 14, "Black");
            }
        }

        printChars(doc);
        Path file = Paths.get("HelloWorldCS5800.txt");
        doc.saveFile(file);
        System.out.println("Save Document: " + file.getFileName());

        Documents loaded = Documents.load(file, factory);
        System.out.println("Load Document: " + file.getFileName());
        System.out.println();
        System.out.println("Loaded Document:");
        printChars(loaded);

        System.out.println("\n" + factory.cacheSize() + " variations in character properties");
    }

    private static void printChars(Documents doc) {
        for (int i = 0; i < doc.length(); i++) {
            Character character = doc.getCharacter(i);
            CharacterProperties p = character.getProperties();
            System.out.printf("%s Font: %s, Color: %s, Size: %d%n",
                    character.getCharacter(), p.getFont(), p.getColor(), p.getSize());
        }
    }
}

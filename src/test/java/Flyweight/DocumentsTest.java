package Flyweight;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentsTest {

    @Test
    void appendAndGetPlainTextTest() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Documents doc = new Documents(factory);
        doc.appendText('C', "Arial", 12, "Red");
        doc.appendText('S', "Calibri", 14, "Blue");

        assertEquals(2, doc.length());
        assertEquals("CS", doc.getPlainText());
    }

    @Test
    void saveAndLoadWorks() throws Exception {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Documents doc = new Documents(factory);
        doc.appendText('G', "Arial", 12, "Red");
        doc.appendText('G', "Verdana", 16, "Black");

        Path tempFile = Files.createTempFile("GG", ".txt");
        doc.saveFile(tempFile);

        Documents loaded = Documents.load(tempFile, factory);
        assertEquals(doc.getPlainText(), loaded.getPlainText());
        assertEquals(2, loaded.length());
    }
}

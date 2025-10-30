package Proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    void songMethodsTest() {
        Song song = new Song(1, "On & On", "aftrr", "aftrrLife", 180);

        assertEquals(1, song.getSongID());
        assertEquals("On & On", song.getTitle());
        assertEquals("aftrr", song.getArtist());
        assertEquals("aftrrLife", song.getAlbum());
        assertEquals(180, song.getDuration());

        String string = song.toString();
        assertTrue(string.contains("On & On"));
        assertTrue(string.contains("aftrr"));
        assertTrue(string.contains("aftrrLife"));
    }
}
package Proxy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SongServiceRealProxyTest {

    private RealSongService realSongService;
    private SongService proxy;

    @BeforeEach
    void setUp() {
        realSongService = new RealSongService();
        realSongService.addSong(new Song(1, "On & On", "aftrr", "aftrrLife", 180));
        realSongService.addSong(new Song(2, "LIMBO", "keshi", "GABRIEL", 160));
        realSongService.addSong(new Song(3, "flash", "2hollis", "star", 150));

        proxy = new SongServiceProxy(realSongService);
    }

    private static long timeMillis(Runnable r) {
        long start = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - start;
    }

    private static final long SLOW_MS = 1000;
    private static final long FAST_MS = 20;

    @Test
    void searchById_MS_test() {
        long start1 = timeMillis(() -> {
            Song song = proxy.searchById(1);
            assertNotNull(song);
            assertEquals(1, song.getSongID());
        });

        long start2 = timeMillis(() -> {
            Song song = proxy.searchById(1);
            assertNotNull(song);
        });

        assertTrue(start1 >= SLOW_MS);
        assertTrue(start2 <= FAST_MS);
    }

    @Test
    void searchByTitle_MS_test() {
        long start1 = timeMillis(() -> {
            List<Song> song = proxy.searchByTitle("On & On");
            assertEquals(1, song.size());
            assertEquals(1, song.get(0).getSongID());
        });

        long start2 = timeMillis(() -> {
            List<Song> song = proxy.searchByTitle("On & On");
            assertEquals(1, song.size());
        });

        assertTrue(start1 >= SLOW_MS);
        assertTrue(start2 <= FAST_MS);
    }

    @Test
    void searchByAlbum_MS_test() {
        long start1 = timeMillis(() -> {
            List<Song> song = proxy.searchByAlbum("GABRIEL");
            assertEquals(1, song.size());
            assertEquals(2, song.get(0).getSongID());
        });

        long start2 = timeMillis(() -> {
            List<Song> song = proxy.searchByAlbum("GABRIEL");
            assertEquals(1, song.size());
        });

        assertTrue(start1 >= SLOW_MS);
        assertTrue(start2 <= FAST_MS);
    }
}
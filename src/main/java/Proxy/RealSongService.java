package Proxy;

import java.util.*;
import java.util.stream.Collectors;

public class RealSongService implements SongService {

    private final Map<Integer, Song> metadata = new HashMap<>();

    public void addSong(Song song) {
        metadata.put(song.getSongID(), song);
    }

    private static void networkDelay() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {}
    }

    @Override
    public Song searchById(Integer songID) {
        networkDelay();
        return metadata.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        networkDelay();
        return metadata.values().stream()
                .filter(song -> song.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        networkDelay();
        return metadata.values().stream()
                .filter(song -> song.getAlbum().equals(album))
                .collect(Collectors.toList());
    }
}
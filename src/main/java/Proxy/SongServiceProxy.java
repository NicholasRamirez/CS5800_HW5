package Proxy;

import java.util.*;

public class SongServiceProxy implements SongService {

    private final SongService songService;

    private final Map<Integer, Song> cacheSongID = new HashMap<>();
    private final Map<String, List<Song>> cacheTitle = new HashMap<>();
    private final Map<String, List<Song>> cacheAlbum = new HashMap<>();

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song searchById(Integer songID) {
        if (cacheSongID.containsKey(songID))
            return cacheSongID.get(songID);
        Song result = songService.searchById(songID);
        if (result != null)
            cacheSongID.put(songID, result);
        return result;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title;
        if (cacheTitle.containsKey(key))
            return cacheTitle.get(key);
        List<Song> result = songService.searchByTitle(title);

        result = Collections.unmodifiableList(new  ArrayList<>(result));
        cacheTitle.put(key,result);

        result.forEach(song -> cacheSongID.putIfAbsent(song.getSongID(), song));
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album;
        if (cacheAlbum.containsKey(key)) return cacheAlbum.get(key);
        List<Song> result = songService.searchByAlbum(album);

        result = Collections.unmodifiableList(new ArrayList<>(result));
        cacheAlbum.put(key, result);

        result.forEach(song -> cacheSongID.putIfAbsent(song.getSongID(), song));
        return result;
    }
}
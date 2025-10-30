package Proxy;

public class Driver {
    public static void main(String[] args) {

        RealSongService realSongService = new RealSongService();

        realSongService.addSong(new Song(1, "On & On", "aftrr", "aftrrLife", 180));
        realSongService.addSong(new Song(2, "LIMBO", "keshi", "GABRIEL", 160));
        realSongService.addSong(new Song(3, "flash", "2hollis", "star", 150));
        realSongService.addSong(new Song(4, "burn my tongue", "starfarll", "alone tonight", 200));
        realSongService.addSong(new Song(5, "FALLING", "pluko", "OXY", 140));

        SongService proxy = new SongServiceProxy(realSongService);

        // ID Search - 1
        System.out.println("\nSearching by ID '1': Proxy fetch from real service");
        long start = System.currentTimeMillis();
        System.out.println(proxy.searchById(1));
        long end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        System.out.println("\nSearching by ID '1' again: Proxy fetch from cache");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchById(1));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        // ID Search - 4
        System.out.println("\nSearching by ID '4': Proxy fetch from real service");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchById(4));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        System.out.println("\nSearching by ID '4' again: Proxy fetch from cache");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchById(4));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");


        // Title Search - " LIMBO "
        System.out.println("\nSearching by Title 'LIMBO': Proxy fetch from real service");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByTitle("LIMBO"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        System.out.println("\nSearching by Title 'LIMBO' again: Proxy fetch from cache");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByTitle("LIMBO"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        // Title Search - " FALLING "
        System.out.println("\nSearching by Title 'FALLING': Proxy fetch from real service");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByTitle("FALLING"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        System.out.println("\nSearching by Title 'FALLING' again: Proxy fetch from cache");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByTitle("FALLING"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");


        // Album Searches - " star "
        System.out.println("\nSearching by Album 'star': Proxy fetch from real service");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByAlbum("star"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");

        System.out.println("\nSearching by Album 'star' again: Proxy fetch from cache");
        start = System.currentTimeMillis();
        System.out.println(proxy.searchByAlbum("star"));
        end = System.currentTimeMillis();
        System.out.println("Search took " + (end - start) + "ms");
    }
}
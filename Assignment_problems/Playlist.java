class Playlist {

    // Private array - original data is hidden
    private String[] songs;

    // Number of songs added
    private int songCount;

    // Constructor
    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    // Add a song
    public void addSong(String song) {
        if (songCount >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    // Return a COPY of the songs
    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    // Return number of songs
    public int getSongCount() {
        return songCount;
    }
}

public class Main {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        // Get a copy
        String[] copy = p.getSongs();

        // Change the copy
        copy[0] = "Hacked";

        System.out.println("Songs in playlist:");

        String[] songs = p.getSongs();

        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i]);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}

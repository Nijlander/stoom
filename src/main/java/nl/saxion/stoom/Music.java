package nl.saxion.stoom;

public class Music {

    private static int nextId = 1;
    private final int id;
    private String title;
    private String artist;
    private String genre;

    /**
     * constructor
     *
     * @param title  title of the song
     * @param artist artist of the song
     * @param genre  genre of the song
     */
    public Music(String title, String artist, String genre) {
        this.id = nextId++;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * returns the id of the song
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returns the title of the song
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the artist of the song
     *
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * returns the genre of the song
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}

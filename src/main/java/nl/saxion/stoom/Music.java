package nl.saxion.stoom;

public class Music {

    private static int nextId = 1;
    private final int id;
    private String title;
    private String genre;
    private String artist;

    /**
     * constructor
     *
     * @param title  titel van het liedje
     * @param genre  genre van het liedje
     * @param artist artiest van het liedje
     */
    public Music(String title, String genre, String artist) {
        this.id = nextId++;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
    }

    /**
     * returnt het id van het liedje
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returnt de titel van het liedje
     *
     * @return titel
     */
    public String getTitle() {
        return title;
    }

    /**
     * returnt de genre van het liedje
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returnt de artiest van het liedje
     *
     * @return artiest
     */
    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}

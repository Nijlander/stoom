package nl.saxion.stoom;

public class Music {

    private int id;
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
    public Music(int id, String title, String genre, String artist) {
        this.id = id;
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

    /**
     * zet het id van het liedje
     *
     * @param id id van het liedje
     */
    public void setId(int id) {
        this.id = id;
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

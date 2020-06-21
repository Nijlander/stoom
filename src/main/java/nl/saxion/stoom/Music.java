package nl.saxion.stoom;

public class Music {

    private int id;
    private String title;
    private String genre;
    private String artist;

    /**
     * constructor
     *
     * @param id     id of the song
     * @param title  title of the song
     * @param genre  genre of the song
     * @param artist artist of the song
     */
    public Music(int id, String title, String genre, String artist) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
    }

    /**
     * returns the id of the song
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * returns the title of the song
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the genre of the song
     *
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returns the artist of the song
     *
     * @return
     */
    public String getArtist() {
        return artist;
    }

    /**
     * sets the id of the song
     *
     * @param id that needs to be set
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

package nl.saxion.stoom;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private String description;

    /**
     * constructor
     *
     * @param id          id of the movie
     * @param title       title of the movie
     * @param genre       genre of the movie
     * @param description description of the movie
     */
    public Movie(int id, String title, String genre, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    /**
     * returns the id of the movie
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * returns the title of the movie
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * returns the genre of the movie
     *
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returns the description of the movie
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the id of the movie
     *
     * @param id id of the movie
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

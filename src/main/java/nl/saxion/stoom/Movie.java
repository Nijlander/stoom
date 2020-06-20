package nl.saxion.stoom;

public class Movie {

    private int id;
    private String title;
    private String genre;
    private String description;

    /**
     * constructor
     *
     * @param title       titel van de film
     * @param genre       genre van de film
     * @param description beschrijving van de film
     */
    public Movie(int id, String title, String genre, String description) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    /**
     * returnt het id van de film
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returnt de titel van de film
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * returnt de genre van de film
     *
     * @return genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * returnt de beschrijving van de film
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

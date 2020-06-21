package nl.saxion.stoom;

public class Game {

    private int id;
    private String name;
    private String category;
    private String description;

    /**
     * constructor
     *
     * @param id          id of the game
     * @param name        name of the game
     * @param category    category of the game
     * @param description description of the game
     */
    public Game(int id, String name, String category, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    /**
     * returns the id of the game
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returns the name of the game
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the description of the game
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns the category of the game
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * sets the id of the game
     *
     * @param id id of the game
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

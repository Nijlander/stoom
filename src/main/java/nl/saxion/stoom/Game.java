package nl.saxion.stoom;

public class Game {

    private static int nextId = 1;
    private final int id;
    private String name;
    private String category;
    private String description;

    /**
     * constructor
     *
     * @param name        naam van het product
     * @param category    categorie waar het product tot toebehoord
     * @param description beschrijving van het product
     */
    public Game(String name, String category, String description) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    /**
     * returnt het id van het product
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * returnt de naam van het product
     *
     * @return naam
     */
    public String getName() {
        return name;
    }

    /**
     * returnt de beschrijving van het product
     *
     * @return beschrijving
     */
    public String getDescription() {
        return description;
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

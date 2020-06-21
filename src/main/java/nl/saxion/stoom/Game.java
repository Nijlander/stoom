package nl.saxion.stoom;

public class Game {

    private int id;
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
    public Game(int id, String name, String category, String description) {
        this.id = id;
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

    /**
     * returnt de categorie van het product
     *
     * @return categorie
     */
    public String getCategory() {
        return category;
    }

    /**
     * zet de id van het product
     *
     * @param id id van het desbetreffende product
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

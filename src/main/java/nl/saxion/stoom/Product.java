package nl.saxion.stoom;

public class Product {

    private static int id;
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
    public Product(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    /**
     * returnt het id van het product
     *
     * @return id
     */
    public static int getId() {
        return id;
    }

    /**
     * returnt de naam van het product
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * returnt de beschrijving van het product
     *
     * @return
     */
    public String getDescription() {
        return description;
    }
}

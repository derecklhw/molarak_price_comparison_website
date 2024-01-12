package mu.dl661.cst3130.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents an alcoholic drink entity.
 */
@Entity
@Table(name = "alcoholic_drinks")
public class AlcoholicDrinks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "category", length = 50, nullable = false)
    private String category;

    @Column(name = "imageUrl", length = 2083)
    private String imageUrl;

    /**
     * Default constructor.
     */
    public AlcoholicDrinks() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param name     The name of the alcoholic drink.
     * @param brand    The brand of the alcoholic drink.
     * @param category The category of the alcoholic drink.
     * @param imageUrl The URL of the image representing the alcoholic drink.
     */
    public AlcoholicDrinks(String name, String brand, String category, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    /**
     * Retrieves the ID of the alcoholic drink.
     * 
     * @return The ID of the alcoholic drink.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the name of the alcoholic drink.
     * 
     * @return The name of the alcoholic drink.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the brand of the alcoholic drink.
     * 
     * @return The brand of the alcoholic drink.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Retrieves the category of the alcoholic drink.
     * 
     * @return The category of the alcoholic drink.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the URL of the image representing the alcoholic drink.
     * 
     * @return The URL of the image representing the alcoholic drink.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the ID of the alcoholic drink.
     * 
     * @param id The ID of the alcoholic drink.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the alcoholic drink.
     * 
     * @param name The name of the alcoholic drink.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the brand of the alcoholic drink.
     * 
     * @param brand The brand of the alcoholic drink.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Sets the category of the alcoholic drink.
     * 
     * @param category The category of the alcoholic drink.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the URL of the image representing the alcoholic drink.
     * 
     * @param imageUrl The URL of the image representing the alcoholic drink.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Returns a string representation of the alcoholic drink.
     * 
     * @return A string representation of the alcoholic drink.
     */
    @Override
    public String toString() {
        return String.format("{id: %d, name: %s, brand: %s, category: %s, }", id, name, brand, category);
    }

}

package mu.dl661.cst3130.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    public AlcoholicDrinks() {
    }

    public AlcoholicDrinks(String name, String brand, String category, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, name: %s, brand: %s, category: %s, }", id, name, brand, category);
    }

}

package mu.dl661.cst3130.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "alcoholic_drinks")
public class AlcoholicDrinks {
    @Id
    @Column(name = "id" )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="brand")
    private String brand;

    @Column(name="category")
    private String category;

    @Lob
    @Column(name="image")
    private byte[] image;

    public AlcoholicDrinks() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(byte[] image) {    
        this.image = image;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, name: %s, brand: %s, category: %s, description: %s}", id, name, brand, category, description);
    }



}
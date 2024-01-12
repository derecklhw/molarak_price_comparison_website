package mu.dl661.cst3130.model;

import jakarta.persistence.*;

/**
 * Represents a volume of an alcoholic drink.
 */
@Entity
@Table(name = "alcoholic_drinks_volumes")
public class AlcoholicDrinksVolume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alcoholic_drinks_id", referencedColumnName = "id", nullable = false)
    private AlcoholicDrinks alcoholicDrink;

    @Column(name = "volume")
    private int volume;

    /**
     * Default constructor.
     */
    public AlcoholicDrinksVolume() {
    }

    /**
     * Constructs a new AlcoholicDrinksVolume object with the given alcoholic drink
     * and volume.
     *
     * @param alcoholicDrink The alcoholic drink associated with the volume.
     * @param volume         The volume of the alcoholic drink.
     */
    public AlcoholicDrinksVolume(AlcoholicDrinks alcoholicDrink, int volume) {
        this.alcoholicDrink = alcoholicDrink;
        this.volume = volume;
    }

    /**
     * Returns the ID of the alcoholic drink volume.
     *
     * @return The ID of the alcoholic drink volume.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the alcoholic drink associated with the volume.
     *
     * @return The alcoholic drink associated with the volume.
     */
    public AlcoholicDrinks getAlcoholicDrink() {
        return alcoholicDrink;
    }

    /**
     * Returns the volume of the alcoholic drink.
     *
     * @return The volume of the alcoholic drink.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the alcoholic drink associated with the volume.
     *
     * @param alcoholicDrink The alcoholic drink to set.
     */
    public void setAlcoholicDrink(AlcoholicDrinks alcoholicDrink) {
        this.alcoholicDrink = alcoholicDrink;
    }

    /**
     * Sets the volume of the alcoholic drink.
     *
     * @param volume The volume to set.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns a string representation of the AlcoholicDrinksVolume object.
     *
     * @return A string representation of the AlcoholicDrinksVolume object.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AlcoholicDrinksVolume{");
        sb.append("id=").append(id);
        sb.append(", alcoholicDrink=").append(alcoholicDrink);
        sb.append(", volume=").append(volume);
        sb.append('}');
        return sb.toString();
    }

}

package mu.dl661.cst3130.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alcoholic_drinks_volumes")
public class AlcoholicDrinksVolume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alcoholic_drinks_id", referencedColumnName = "id", nullable = false)
    private AlcoholicDrinks alcoholicDrink;

    @Column(name = "volume", length = 25, nullable = false)
    private String volume;

    public AlcoholicDrinksVolume() {
    }

    public int getId() {
        return id;
    }

    public AlcoholicDrinks getAlcoholicDrink() {
        return alcoholicDrink;
    }

    public String getVolume() {
        return volume;
    }

    public void setAlcoholicDrink(AlcoholicDrinks alcoholicDrink) {
        this.alcoholicDrink = alcoholicDrink;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

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

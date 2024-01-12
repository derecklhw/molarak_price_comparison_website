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

    @Column(name = "volume")
    private int volume;

    public AlcoholicDrinksVolume() {
    }

    public AlcoholicDrinksVolume(AlcoholicDrinks alcoholicDrink, int volume) {
        this.alcoholicDrink = alcoholicDrink;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public AlcoholicDrinks getAlcoholicDrink() {
        return alcoholicDrink;
    }

    public int getVolume() {
        return volume;
    }

    public void setAlcoholicDrink(AlcoholicDrinks alcoholicDrink) {
        this.alcoholicDrink = alcoholicDrink;
    }

    public void setVolume(int volume) {
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

package mu.dl661.cst3130.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comparison")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "alcoholic_drinks_volumes_id", referencedColumnName = "id", nullable = false)
    private AlcoholicDrinksVolume alcoholicDrinkVolume;

    @Column(name = "website_name", length = 100, nullable = false)
    private String websiteName;

    @Column(name = "website_url", length = 255, nullable = false)
    private String websiteUrl;

    @Column(name = "price")
    private double price;

    public Comparison() {
    }

    public Comparison(AlcoholicDrinksVolume alcoholicDrinkVolume, String websiteName, String websiteUrl,
            double price) {
        this.alcoholicDrinkVolume = alcoholicDrinkVolume;
        this.websiteName = websiteName;
        this.websiteUrl = websiteUrl;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public AlcoholicDrinksVolume getAlcoholicDrinkVolume() {
        return alcoholicDrinkVolume;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setAlcoholicDrinkVolume(AlcoholicDrinksVolume alcoholicDrinkVolume) {
        this.alcoholicDrinkVolume = alcoholicDrinkVolume;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comparison{");
        sb.append("id=").append(id);
        sb.append(", alcoholicDrinkVolume=").append(alcoholicDrinkVolume);
        sb.append(", websiteName='").append(websiteName).append('\'');
        sb.append(", websiteUrl='").append(websiteUrl).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}

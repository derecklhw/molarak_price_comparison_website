package mu.dl661.cst3130.model;

import jakarta.persistence.*;

/**
 * Represents a comparison between different alcoholic drinks volumes on a
 * website.
 */
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

    @Column(name = "website_url", length = 2083, nullable = false)
    private String websiteUrl;

    @Column(name = "price")
    private double price;

    /**
     * Default constructor.
     */
    public Comparison() {
    }

    /**
     * Constructor with parameters.
     * 
     * @param alcoholicDrinkVolume The alcoholic drinks volume for the comparison.
     * @param websiteName          The name of the website.
     * @param websiteUrl           The URL of the website.
     * @param price                The price of the comparison.
     */
    public Comparison(AlcoholicDrinksVolume alcoholicDrinkVolume, String websiteName, String websiteUrl,
            double price) {
        this.alcoholicDrinkVolume = alcoholicDrinkVolume;
        this.websiteName = websiteName;
        this.websiteUrl = websiteUrl;
        this.price = price;
    }

    /**
     * Get the ID of the comparison.
     * 
     * @return The ID of the comparison.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the alcoholic drinks volume for the comparison.
     * 
     * @return The alcoholic drinks volume for the comparison.
     */
    public AlcoholicDrinksVolume getAlcoholicDrinkVolume() {
        return alcoholicDrinkVolume;
    }

    /**
     * Get the name of the website.
     * 
     * @return The name of the website.
     */
    public String getWebsiteName() {
        return websiteName;
    }

    /**
     * Get the URL of the website.
     * 
     * @return The URL of the website.
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * Get the price of the comparison.
     * 
     * @return The price of the comparison.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the alcoholic drinks volume for the comparison.
     * 
     * @param alcoholicDrinkVolume The alcoholic drinks volume for the comparison.
     */
    public void setAlcoholicDrinkVolume(AlcoholicDrinksVolume alcoholicDrinkVolume) {
        this.alcoholicDrinkVolume = alcoholicDrinkVolume;
    }

    /**
     * Set the name of the website.
     * 
     * @param websiteName The name of the website.
     */
    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    /**
     * Set the URL of the website.
     * 
     * @param websiteUrl The URL of the website.
     */
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    /**
     * Set the price of the comparison.
     * 
     * @param price The price of the comparison.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get a string representation of the Comparison object.
     * 
     * @return A string representation of the Comparison object.
     */
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

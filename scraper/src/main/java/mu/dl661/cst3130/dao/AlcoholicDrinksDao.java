package mu.dl661.cst3130.dao;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinks;

/**
 * The AlcoholicDrinksDao interface represents the data access object for
 * alcoholic drinks.
 * It provides methods to save, update, delete, and retrieve alcoholic drinks
 * from the database.
 */
public interface AlcoholicDrinksDao {
    /**
     * Saves the given alcoholic drinks object to the database.
     *
     * @param alcoholicDrinks The alcoholic drinks object to be saved.
     */
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    /**
     * Updates the given alcoholic drinks object in the database.
     *
     * @param alcoholicDrinks The alcoholic drinks object to be updated.
     */
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    /**
     * Deletes the alcoholic drinks with the specified ID from the database.
     *
     * @param id The ID of the alcoholic drinks to be deleted.
     */
    public void deleteAlcoholicDrinks(int id);

    /**
     * Retrieves the alcoholic drinks with the specified ID from the database.
     *
     * @param id The ID of the alcoholic drinks to be retrieved.
     * @return The alcoholic drinks object with the specified ID, or null if not
     *         found.
     */
    public AlcoholicDrinks getAlcoholicDrinksById(int id);

    /**
     * Retrieves the alcoholic drinks with the specified name and brand from the
     * database.
     *
     * @param name  The name of the alcoholic drinks to be retrieved.
     * @param brand The brand of the alcoholic drinks to be retrieved.
     * @return The alcoholic drinks object with the specified name and brand, or
     *         null if not found.
     */
    public AlcoholicDrinks getAlcoholicDrinksByNameAndBrand(String name, String brand);

    /**
     * Retrieves all the alcoholic drinks from the database.
     *
     * @return A list of all alcoholic drinks in the database.
     */
    List<AlcoholicDrinks> getAllAlcoholicDrinks();

    /**
     * Deletes all the alcoholic drinks from the database.
     */
    public void deleteAllAlcoholicDrinks();
}

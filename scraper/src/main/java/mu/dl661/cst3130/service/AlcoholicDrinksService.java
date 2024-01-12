package mu.dl661.cst3130.service;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinks;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;
import mu.dl661.cst3130.model.Comparison;

/**
 * The AlcoholicDrinksService interface provides methods for managing alcoholic
 * drinks.
 */
public interface AlcoholicDrinksService {

    /**
     * Saves the given alcoholic drinks, alcoholic drinks volume, and comparison.
     *
     * @param alcoholicDrinks       The alcoholic drinks to be saved.
     * @param alcoholicDrinksVolume The alcoholic drinks volume to be saved.
     * @param comparison            The comparison to be saved.
     */
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks, AlcoholicDrinksVolume alcoholicDrinksVolume,
            Comparison comparison);

    /**
     * Updates the given alcoholic drinks.
     *
     * @param alcoholicDrinks The alcoholic drinks to be updated.
     */
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    /**
     * Deletes the alcoholic drinks with the specified ID.
     *
     * @param id The ID of the alcoholic drinks to be deleted.
     */
    public void deleteAlcoholicDrinks(int id);

    /**
     * Retrieves the alcoholic drinks with the specified ID.
     *
     * @param id The ID of the alcoholic drinks to be retrieved.
     * @return The alcoholic drinks with the specified ID, or null if not found.
     */
    public AlcoholicDrinks getAlcoholicDrinksById(int id);

    /**
     * Retrieves all alcoholic drinks.
     *
     * @return A list of all alcoholic drinks.
     */
    List<AlcoholicDrinks> getAllAlcoholicDrinks();

    /**
     * Deletes all alcoholic drinks.
     */
    public void deleteAllAlcoholicDrinks();
}
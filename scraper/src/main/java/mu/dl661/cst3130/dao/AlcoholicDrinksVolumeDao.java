package mu.dl661.cst3130.dao;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinksVolume;

/**
 * The AlcoholicDrinksVolumeDao interface represents the data access object for
 * alcoholic drinks volume.
 * It provides methods to save, update, delete, and retrieve alcoholic drinks
 * volume from the database.
 */
public interface AlcoholicDrinksVolumeDao {
    /**
     * Saves an AlcoholicDrinksVolume object to the database.
     *
     * @param alcoholicDrinksVolume The AlcoholicDrinksVolume object to be saved.
     */
    public void saveAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume);

    /**
     * Updates an existing AlcoholicDrinksVolume object in the database.
     *
     * @param alcoholicDrinksVolume The AlcoholicDrinksVolume object to be updated.
     */
    public void updateAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume);

    /**
     * Deletes an AlcoholicDrinksVolume object from the database based on its ID.
     *
     * @param id The ID of the AlcoholicDrinksVolume object to be deleted.
     */
    public void deleteAlcoholicDrinksVolume(int id);

    /**
     * Retrieves an AlcoholicDrinksVolume object from the database based on its ID.
     *
     * @param id The ID of the AlcoholicDrinksVolume object to be retrieved.
     * @return The AlcoholicDrinksVolume object with the specified ID, or null if
     *         not found.
     */
    public AlcoholicDrinksVolume getAlcoholicDrinksVolumeById(int id);

    /**
     * Retrieves all AlcoholicDrinksVolume objects from the database.
     *
     * @return A list of all AlcoholicDrinksVolume objects in the database.
     */
    List<AlcoholicDrinksVolume> getAllAlcoholicDrinksVolume();

    /**
     * Deletes all AlcoholicDrinksVolume objects from the database.
     */
    public void deleteAllAlcoholicDrinksVolume();
}

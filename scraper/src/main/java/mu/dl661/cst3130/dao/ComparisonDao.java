package mu.dl661.cst3130.dao;

import java.util.List;

import mu.dl661.cst3130.model.Comparison;

/**
 * The ComparisonDao interface provides methods to interact with the Comparison
 * data in the database.
 */
public interface ComparisonDao {

    /**
     * Saves a Comparison object to the database.
     *
     * @param comparison The Comparison object to be saved.
     */
    public void saveComparison(Comparison comparison);

    /**
     * Updates a Comparison object in the database.
     *
     * @param comparison The Comparison object to be updated.
     */
    public void updateComparison(Comparison comparison);

    /**
     * Deletes a Comparison object from the database based on its ID.
     *
     * @param id The ID of the Comparison object to be deleted.
     */
    public void deleteComparison(int id);

    /**
     * Retrieves a Comparison object from the database based on its ID.
     *
     * @param id The ID of the Comparison object to be retrieved.
     * @return The Comparison object with the specified ID, or null if not found.
     */
    public Comparison getComparisonById(int id);

    /**
     * Retrieves all Comparison objects from the database.
     *
     * @return A list of all Comparison objects in the database.
     */
    List<Comparison> getAllComparison();

    /**
     * Deletes all Comparison objects from the database.
     */
    public void deleteAllComparison();

}

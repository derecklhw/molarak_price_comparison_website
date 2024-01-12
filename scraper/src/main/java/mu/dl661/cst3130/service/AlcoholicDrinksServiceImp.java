package mu.dl661.cst3130.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.model.AlcoholicDrinks;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;
import mu.dl661.cst3130.model.Comparison;

/**
 * This class implements the AlcoholicDrinksService interface and provides
 * methods to interact with the alcoholic drinks data.
 */
public class AlcoholicDrinksServiceImp implements AlcoholicDrinksService {

    private AlcoholicDrinksDao alcoholicDrinksDao;
    private AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao;
    private ComparisonDao comparisonDao;

    /**
     * Sets the AlcoholicDrinksDao dependency.
     *
     * @param alcoholicDrinksDao The AlcoholicDrinksDao implementation to be set.
     */
    public void setAlcoholicDrinksDao(AlcoholicDrinksDao alcoholicDrinksDao) {
        this.alcoholicDrinksDao = alcoholicDrinksDao;
    }

    /**
     * Sets the AlcoholicDrinksVolumeDao dependency.
     *
     * @param alcoholicDrinksVolumeDao The AlcoholicDrinksVolumeDao implementation
     *                                 to be set.
     */
    public void setAlcoholicDrinksVolumeDao(AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao) {
        this.alcoholicDrinksVolumeDao = alcoholicDrinksVolumeDao;
    }

    /**
     * Sets the ComparisonDao dependency.
     *
     * @param comparisonDao The ComparisonDao implementation to be set.
     */
    public void setComparisonDao(ComparisonDao comparisonDao) {
        this.comparisonDao = comparisonDao;
    }

    /**
     * Saves the alcoholic drinks, alcoholic drinks volume, and comparison data.
     * If the alcoholic drinks already exist, only the alcoholic drinks volume and
     * comparison data are saved.
     *
     * @param alcoholicDrinks       The alcoholic drinks to be saved.
     * @param alcoholicDrinksVolume The alcoholic drinks volume to be saved.
     * @param comparison            The comparison data to be saved.
     */
    @Override
    @Transactional
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks, AlcoholicDrinksVolume alcoholicDrinksVolume,
            Comparison comparison) {

        AlcoholicDrinks existingAlcoholicDrinks = alcoholicDrinksDao.getAlcoholicDrinksByNameAndBrand(
                alcoholicDrinks.getName(),
                alcoholicDrinks.getBrand());
        if (existingAlcoholicDrinks == null) {
            this.alcoholicDrinksDao.saveAlcoholicDrinks(alcoholicDrinks);
            this.alcoholicDrinksVolumeDao.saveAlcoholicDrinksVolume(alcoholicDrinksVolume);
            this.comparisonDao.saveComparison(comparison);
        } else {
            alcoholicDrinksVolume.setAlcoholicDrink(existingAlcoholicDrinks);
            this.alcoholicDrinksVolumeDao.saveAlcoholicDrinksVolume(alcoholicDrinksVolume);
            this.comparisonDao.saveComparison(comparison);
        }
    }

    /**
     * Updates the alcoholic drinks data.
     *
     * @param alcoholicDrinks The alcoholic drinks to be updated.
     */
    @Override
    @Transactional
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        this.alcoholicDrinksDao.updateAlcoholicDrinks(alcoholicDrinks);
    }

    /**
     * Deletes the alcoholic drinks data with the specified ID.
     *
     * @param id The ID of the alcoholic drinks to be deleted.
     */
    @Override
    @Transactional
    public void deleteAlcoholicDrinks(int id) {
        this.alcoholicDrinksDao.deleteAlcoholicDrinks(id);
    }

    /**
     * Retrieves the alcoholic drinks data with the specified ID.
     *
     * @param id The ID of the alcoholic drinks to be retrieved.
     * @return The alcoholic drinks with the specified ID.
     */
    @Override
    @Transactional
    public AlcoholicDrinks getAlcoholicDrinksById(int id) {
        return this.alcoholicDrinksDao.getAlcoholicDrinksById(id);
    }

    /**
     * Retrieves all the alcoholic drinks data.
     *
     * @return A list of all the alcoholic drinks.
     */
    @Override
    @Transactional
    public List<AlcoholicDrinks> getAllAlcoholicDrinks() {
        return this.alcoholicDrinksDao.getAllAlcoholicDrinks();
    }

    /**
     * Deletes all the alcoholic drinks data, alcoholic drinks volume data, and
     * comparison data.
     */
    @Override
    @Transactional
    public void deleteAllAlcoholicDrinks() {
        this.comparisonDao.deleteAllComparison();
        this.alcoholicDrinksVolumeDao.deleteAllAlcoholicDrinksVolume();
        this.alcoholicDrinksDao.deleteAllAlcoholicDrinks();
    }
}

package mu.dl661.cst3130.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.model.AlcoholicDrinks;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;
import mu.dl661.cst3130.model.Comparison;

public class AlcoholicDrinksServiceImp implements AlcoholicDrinksService {

    private AlcoholicDrinksDao alcoholicDrinksDao;
    private AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao;
    private ComparisonDao comparisonDao;

    public void setAlcoholicDrinksDao(AlcoholicDrinksDao alcoholicDrinksDao) {
        this.alcoholicDrinksDao = alcoholicDrinksDao;
    }

    public void setAlcoholicDrinksVolumeDao(AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao) {
        this.alcoholicDrinksVolumeDao = alcoholicDrinksVolumeDao;
    }

    public void setComparisonDao(ComparisonDao comparisonDao) {
        this.comparisonDao = comparisonDao;
    }

    @Override
    @Transactional
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks, AlcoholicDrinksVolume alcoholicDrinksVolume,
            Comparison comparison) {
        this.alcoholicDrinksDao.saveAlcoholicDrinks(alcoholicDrinks);
        this.alcoholicDrinksVolumeDao.saveAlcoholicDrinksVolume(alcoholicDrinksVolume);
        this.comparisonDao.saveComparison(comparison);
    }

    @Override
    @Transactional
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        this.alcoholicDrinksDao.updateAlcoholicDrinks(alcoholicDrinks);
    }

    @Override
    @Transactional
    public void deleteAlcoholicDrinks(int id) {
        this.alcoholicDrinksDao.deleteAlcoholicDrinks(id);
    }

    @Override
    @Transactional
    public AlcoholicDrinks getAlcoholicDrinksById(int id) {
        return this.alcoholicDrinksDao.getAlcoholicDrinksById(id);
    }

    @Override
    @Transactional
    public List<AlcoholicDrinks> getAllAlcoholicDrinks() {
        return this.alcoholicDrinksDao.getAllAlcoholicDrinks();
    }

    @Override
    @Transactional
    public void deleteAllAlcoholicDrinks() {
        this.comparisonDao.deleteAllComparison();
        this.alcoholicDrinksVolumeDao.deleteAllAlcoholicDrinksVolume();
        this.alcoholicDrinksDao.deleteAllAlcoholicDrinks();
    }
}

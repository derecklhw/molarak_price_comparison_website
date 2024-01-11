package mu.dl661.cst3130.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.model.AlcoholicDrinks;

public class AlcoholicDrinksServiceImp implements AlcoholicDrinksService {

    private AlcoholicDrinksDao alcoholicDrinksDao;

    public void setAlcoholicDrinksDao(AlcoholicDrinksDao alcoholicDrinksDao) {
        this.alcoholicDrinksDao = alcoholicDrinksDao;
    }

    @Override
    @Transactional
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        this.alcoholicDrinksDao.saveAlcoholicDrinks(alcoholicDrinks);
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
}

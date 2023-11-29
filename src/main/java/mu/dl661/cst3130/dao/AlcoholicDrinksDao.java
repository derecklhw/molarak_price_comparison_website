package mu.dl661.cst3130.dao;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinks;

public interface AlcoholicDrinksDao {
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);
    public void updateAlcoholicDrinks();
    public void deleteAlcoholicDrinks();
    public AlcoholicDrinks getAlcoholicDrinksById(int id);
    List<AlcoholicDrinks> getAllAlcoholicDrinks();
}

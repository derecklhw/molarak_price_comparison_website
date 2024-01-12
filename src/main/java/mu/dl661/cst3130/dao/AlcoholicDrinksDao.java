package mu.dl661.cst3130.dao;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinks;

public interface AlcoholicDrinksDao {
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    public void deleteAlcoholicDrinks(int id);

    public AlcoholicDrinks getAlcoholicDrinksById(int id);

    public AlcoholicDrinks getAlcoholicDrinksByNameAndBrand(String name, String brand);

    List<AlcoholicDrinks> getAllAlcoholicDrinks();

    public void deleteAllAlcoholicDrinks();
}

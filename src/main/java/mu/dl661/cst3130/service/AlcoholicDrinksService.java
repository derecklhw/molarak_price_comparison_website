package mu.dl661.cst3130.service;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinks;

public interface AlcoholicDrinksService {
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks);

    public void deleteAlcoholicDrinks(int id);

    public AlcoholicDrinks getAlcoholicDrinksById(int id);

    List<AlcoholicDrinks> getAllAlcoholicDrinks();
}
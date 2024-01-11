package mu.dl661.cst3130.service;

import java.util.List;

import mu.dl661.cst3130.model.AlcoholicDrinksVolume;;

public interface AlcoholicDrinksVolumeService {
    public void saveAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume);

    public void updateAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume);

    public void deleteAlcoholicDrinksVolume(int id);

    public AlcoholicDrinksVolume getAlcoholicDrinksVolumeById(int id);

    List<AlcoholicDrinksVolume> getAllAlcoholicDrinksVolume();
}
package mu.dl661.cst3130.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;

public class AlcoholicDrinksVolumeServiceImpl implements AlcoholicDrinksVolumeService {

    private AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao;

    public void setAlcoholicDrinksVolumeDao(AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao) {
        this.alcoholicDrinksVolumeDao = alcoholicDrinksVolumeDao;
    }

    @Override
    @Transactional
    public void saveAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        this.alcoholicDrinksVolumeDao.saveAlcoholicDrinksVolume(alcoholicDrinksVolume);
    }

    @Override
    @Transactional
    public void updateAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        this.alcoholicDrinksVolumeDao.updateAlcoholicDrinksVolume(alcoholicDrinksVolume);
    }

    @Override
    @Transactional
    public void deleteAlcoholicDrinksVolume(int id) {
        this.alcoholicDrinksVolumeDao.deleteAlcoholicDrinksVolume(id);
    }

    @Override
    @Transactional
    public AlcoholicDrinksVolume getAlcoholicDrinksVolumeById(int id) {
        return this.alcoholicDrinksVolumeDao.getAlcoholicDrinksVolumeById(id);
    }

    @Override
    @Transactional
    public List<AlcoholicDrinksVolume> getAllAlcoholicDrinksVolume() {
        return this.alcoholicDrinksVolumeDao.getAllAlcoholicDrinksVolume();
    }
}

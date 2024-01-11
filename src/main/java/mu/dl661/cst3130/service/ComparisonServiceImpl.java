package mu.dl661.cst3130.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.model.Comparison;

public class ComparisonServiceImpl implements ComparisonService {

    private ComparisonDao comparisonDao;

    public void setComparisonDao(ComparisonDao comparisonDao) {
        this.comparisonDao = comparisonDao;
    }

    @Override
    @Transactional
    public void saveComparison(Comparison comparison) {
        this.comparisonDao.saveComparison(comparison);
    }

    @Override
    @Transactional
    public void updateComparison(Comparison comparison) {
        this.comparisonDao.updateComparison(comparison);
    }

    @Override
    @Transactional
    public void deleteComparison(int id) {
        this.comparisonDao.deleteComparison(id);
    }

    @Override
    @Transactional
    public Comparison getComparisonById(int id) {
        return this.comparisonDao.getComparisonById(id);
    }

    @Override
    @Transactional
    public List<Comparison> getAllComparison() {
        return this.comparisonDao.getAllComparison();
    }
}

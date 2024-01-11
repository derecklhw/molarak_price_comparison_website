package mu.dl661.cst3130.service;

import java.util.List;

import mu.dl661.cst3130.model.Comparison;

public interface ComparisonService {
    public void saveComparison(Comparison comparison);

    public void updateComparison(Comparison comparison);

    public void deleteComparison(int id);

    public Comparison getComparisonById(int id);

    List<Comparison> getAllComparison();
}

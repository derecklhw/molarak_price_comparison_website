package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mu.dl661.cst3130.model.AlcoholicDrinks;

public class AlcoholicDrinksDaoImpl implements AlcoholicDrinksDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(alcoholicDrinks);
        tx.commit();
        session.close();
    }

    @Override
    public void updateAlcoholicDrinks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAlcoholicDrinks'");
    }

    @Override
    public void deleteAlcoholicDrinks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAlcoholicDrinks'");
    }

    @Override
    public AlcoholicDrinks getAlcoholicDrinksById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlcoholicDrinksById'");
    }

    @Override
    public List<AlcoholicDrinks> getAllAlcoholicDrinks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAlcoholicDrinks'");
    }
    
}

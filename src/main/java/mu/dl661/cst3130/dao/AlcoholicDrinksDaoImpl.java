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
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(alcoholicDrinks);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteAlcoholicDrinks(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        AlcoholicDrinks persistentInstance = session.get(AlcoholicDrinks.class, id);
        if (persistentInstance != null) {
            session.remove(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    @Override
    public AlcoholicDrinks getAlcoholicDrinksById(int id) {
        Session session = this.sessionFactory.openSession();
        AlcoholicDrinks alcoholicDrinks = session.get(AlcoholicDrinks.class, id);
        session.close();
        return alcoholicDrinks;
    }

    @Override
    public List<AlcoholicDrinks> getAllAlcoholicDrinks() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<AlcoholicDrinks> query = session.createQuery("from AlcoholicDrinks", AlcoholicDrinks.class);
        List<AlcoholicDrinks> alcoholicDrinksList = query.list();
        session.close();
        return alcoholicDrinksList; 
    }
    
}

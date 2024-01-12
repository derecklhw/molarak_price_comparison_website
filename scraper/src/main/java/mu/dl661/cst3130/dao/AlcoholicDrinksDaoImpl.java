package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import mu.dl661.cst3130.model.AlcoholicDrinks;

/**
 * Implementation of the AlcoholicDrinksDao interface.
 * Provides methods to perform CRUD operations on AlcoholicDrinks entities.
 */
public class AlcoholicDrinksDaoImpl implements AlcoholicDrinksDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Sets the SessionFactory to be used by this DAO.
     * 
     * @param sessionFactory the SessionFactory to be set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Saves an AlcoholicDrinks entity to the database.
     * 
     * @param alcoholicDrinks the AlcoholicDrinks entity to be saved
     */
    @Override
    public void saveAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(alcoholicDrinks);
        tx.commit();
        session.close();
    }

    /**
     * Updates an existing AlcoholicDrinks entity in the database.
     * 
     * @param alcoholicDrinks the AlcoholicDrinks entity to be updated
     */
    @Override
    public void updateAlcoholicDrinks(AlcoholicDrinks alcoholicDrinks) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(alcoholicDrinks);
        tx.commit();
        session.close();
    }

    /**
     * Deletes an AlcoholicDrinks entity from the database based on its ID.
     * 
     * @param id the ID of the AlcoholicDrinks entity to be deleted
     */
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

    /**
     * Retrieves an AlcoholicDrinks entity from the database based on its ID.
     * 
     * @param id the ID of the AlcoholicDrinks entity to be retrieved
     * @return the retrieved AlcoholicDrinks entity, or null if not found
     */
    @Override
    public AlcoholicDrinks getAlcoholicDrinksById(int id) {
        Session session = this.sessionFactory.openSession();
        AlcoholicDrinks alcoholicDrinks = session.get(AlcoholicDrinks.class, id);
        session.close();
        return alcoholicDrinks;
    }

    /**
     * Retrieves an AlcoholicDrinks entity from the database based on its name and
     * brand.
     * 
     * @param name  the name of the AlcoholicDrinks entity to be retrieved
     * @param brand the brand of the AlcoholicDrinks entity to be retrieved
     * @return the retrieved AlcoholicDrinks entity, or null if not found
     */
    @Override
    public AlcoholicDrinks getAlcoholicDrinksByNameAndBrand(String name, String brand) {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<AlcoholicDrinks> query = session.createQuery(
                "from AlcoholicDrinks where name = :name and brand = :brand", AlcoholicDrinks.class);
        query.setParameter("name", name);
        query.setParameter("brand", brand);
        AlcoholicDrinks alcoholicDrinks = query.uniqueResult();
        session.close();
        return alcoholicDrinks;
    }

    /**
     * Retrieves all AlcoholicDrinks entities from the database.
     * 
     * @return a list of all AlcoholicDrinks entities
     */
    @Override
    public List<AlcoholicDrinks> getAllAlcoholicDrinks() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<AlcoholicDrinks> query = session.createQuery("from AlcoholicDrinks",
                AlcoholicDrinks.class);
        List<AlcoholicDrinks> alcoholicDrinksList = query.list();
        session.close();
        return alcoholicDrinksList;
    }

    /**
     * Deletes all AlcoholicDrinks entities from the database.
     */
    @Override
    public void deleteAllAlcoholicDrinks() {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        org.hibernate.query.Query<AlcoholicDrinks> query = session.createQuery("from AlcoholicDrinks",
                AlcoholicDrinks.class);
        List<AlcoholicDrinks> alcoholicDrinksList = query.list();
        for (AlcoholicDrinks alcoholicDrinks : alcoholicDrinksList) {
            session.remove(alcoholicDrinks);
        }
        tx.commit();
        session.close();
    }
}

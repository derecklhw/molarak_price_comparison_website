package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import mu.dl661.cst3130.model.Comparison;

/**
 * Implementation of the ComparisonDao interface.
 * Provides methods to interact with the Comparison entity in the database.
 */
public class ComparisonDaoImpl implements ComparisonDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Sets the SessionFactory to be used for database operations.
     * 
     * @param sessionFactory the SessionFactory to be set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Saves a Comparison object to the database.
     * 
     * @param comparison the Comparison object to be saved
     */
    @Override
    public void saveComparison(Comparison comparison) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(comparison);
        tx.commit();
        session.close();
    }

    /**
     * Updates a Comparison object in the database.
     * 
     * @param comparison the Comparison object to be updated
     */
    @Override
    public void updateComparison(Comparison comparison) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(comparison);
        tx.commit();
        session.close();
    }

    /**
     * Deletes a Comparison object from the database based on its ID.
     * 
     * @param id the ID of the Comparison object to be deleted
     */
    @Override
    public void deleteComparison(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Comparison persistentInstance = session.get(Comparison.class, id);
        if (persistentInstance != null) {
            session.remove(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    /**
     * Retrieves a Comparison object from the database based on its ID.
     * 
     * @param id the ID of the Comparison object to be retrieved
     * @return the retrieved Comparison object, or null if not found
     */
    @Override
    public Comparison getComparisonById(int id) {
        Session session = this.sessionFactory.openSession();
        Comparison comparison = session.get(Comparison.class, id);
        session.close();
        return comparison;
    }

    /**
     * Retrieves all Comparison objects from the database.
     * 
     * @return a list of all Comparison objects in the database
     */
    @Override
    public List<Comparison> getAllComparison() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Comparison> query = session.createQuery("from Comparison", Comparison.class);
        List<Comparison> comparisonList = query.list();
        session.close();
        return comparisonList;
    }

    /**
     * Deletes all Comparison objects from the database.
     */
    @Override
    public void deleteAllComparison() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from Comparison").executeUpdate();
        tx.commit();
    }
}
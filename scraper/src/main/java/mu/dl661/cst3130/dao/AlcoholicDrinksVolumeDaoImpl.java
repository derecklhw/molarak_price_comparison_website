package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import mu.dl661.cst3130.model.AlcoholicDrinksVolume;

/**
 * This class implements the AlcoholicDrinksVolumeDao interface and provides
 * the implementation for CRUD operations related to AlcoholicDrinksVolume
 * objects.
 */
public class AlcoholicDrinksVolumeDaoImpl implements AlcoholicDrinksVolumeDao {

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
     * Saves the given AlcoholicDrinksVolume object to the database.
     *
     * @param alcoholicDrinksVolume the AlcoholicDrinksVolume object to be saved
     */
    @Override
    public void saveAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(alcoholicDrinksVolume);
        tx.commit();
        session.close();
    }

    /**
     * Updates the given AlcoholicDrinksVolume object in the database.
     *
     * @param alcoholicDrinksVolume the AlcoholicDrinksVolume object to be updated
     */
    @Override
    public void updateAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(alcoholicDrinksVolume);
        tx.commit();
        session.close();
    }

    /**
     * Deletes the AlcoholicDrinksVolume object with the specified ID from the
     * database.
     *
     * @param id the ID of the AlcoholicDrinksVolume object to be deleted
     */
    @Override
    public void deleteAlcoholicDrinksVolume(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        AlcoholicDrinksVolume persistentInstance = session.get(AlcoholicDrinksVolume.class, id);
        if (persistentInstance != null) {
            session.remove(persistentInstance);
        }
        tx.commit();
        session.close();
    }

    /**
     * Retrieves the AlcoholicDrinksVolume object with the specified ID from the
     * database.
     *
     * @param id the ID of the AlcoholicDrinksVolume object to be retrieved
     * @return the AlcoholicDrinksVolume object with the specified ID, or null if
     *         not found
     */
    @Override
    public AlcoholicDrinksVolume getAlcoholicDrinksVolumeById(int id) {
        Session session = this.sessionFactory.openSession();
        AlcoholicDrinksVolume alcoholicDrinksVolume = session.get(AlcoholicDrinksVolume.class, id);
        session.close();
        return alcoholicDrinksVolume;
    }

    /**
     * Retrieves all AlcoholicDrinksVolume objects from the database.
     *
     * @return a list of all AlcoholicDrinksVolume objects
     */
    @Override
    public List<AlcoholicDrinksVolume> getAllAlcoholicDrinksVolume() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<AlcoholicDrinksVolume> query = session.createQuery("from AlcoholicDrinksVolume",
                AlcoholicDrinksVolume.class);
        List<AlcoholicDrinksVolume> alcoholicDrinksVolumeList = query.list();
        session.close();
        return alcoholicDrinksVolumeList;
    }

    /**
     * Deletes all AlcoholicDrinksVolume objects from the database.
     */
    @Override
    public void deleteAllAlcoholicDrinksVolume() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from AlcoholicDrinksVolume").executeUpdate();
        tx.commit();
    }
}

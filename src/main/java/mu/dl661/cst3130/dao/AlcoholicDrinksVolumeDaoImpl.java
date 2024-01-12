package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import mu.dl661.cst3130.model.AlcoholicDrinksVolume;

public class AlcoholicDrinksVolumeDaoImpl implements AlcoholicDrinksVolumeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(alcoholicDrinksVolume);
        tx.commit();
        session.close();
    }

    @Override
    public void updateAlcoholicDrinksVolume(AlcoholicDrinksVolume alcoholicDrinksVolume) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(alcoholicDrinksVolume);
        tx.commit();
        session.close();
    }

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

    @Override
    public AlcoholicDrinksVolume getAlcoholicDrinksVolumeById(int id) {
        Session session = this.sessionFactory.openSession();
        AlcoholicDrinksVolume alcoholicDrinksVolume = session.get(AlcoholicDrinksVolume.class, id);
        session.close();
        return alcoholicDrinksVolume;
    }

    @Override
    public List<AlcoholicDrinksVolume> getAllAlcoholicDrinksVolume() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<AlcoholicDrinksVolume> query = session.createQuery("from AlcoholicDrinksVolume",
                AlcoholicDrinksVolume.class);
        List<AlcoholicDrinksVolume> alcoholicDrinksVolumeList = query.list();
        session.close();
        return alcoholicDrinksVolumeList;
    }

    @Override
    public void deleteAllAlcoholicDrinksVolume() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.createQuery("delete from AlcoholicDrinksVolume").executeUpdate();
        tx.commit();
    }
}

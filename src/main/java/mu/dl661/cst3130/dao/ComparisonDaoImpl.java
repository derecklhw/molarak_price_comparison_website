package mu.dl661.cst3130.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mu.dl661.cst3130.model.Comparison;

@Repository("comparisonDao")
public class ComparisonDaoImpl implements ComparisonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveComparison(Comparison comparison) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(comparison);
        tx.commit();
        session.close();
    }

    @Override
    public void updateComparison(Comparison comparison) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(comparison);
        tx.commit();
        session.close();
    }

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

    @Override
    public Comparison getComparisonById(int id) {
        Session session = this.sessionFactory.openSession();
        Comparison comparison = session.get(Comparison.class, id);
        session.close();
        return comparison;
    }

    @Override
    public List<Comparison> getAllComparison() {
        Session session = this.sessionFactory.openSession();
        org.hibernate.query.Query<Comparison> query = session.createQuery("from Comparison", Comparison.class);
        List<Comparison> comparisonList = query.list();
        session.close();
        return comparisonList;
    }
}

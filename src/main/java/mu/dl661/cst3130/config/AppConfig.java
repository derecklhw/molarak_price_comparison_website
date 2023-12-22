package mu.dl661.cst3130.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksDaoImpl;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDaoImpl;
import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.dao.ComparisonDaoImpl;

@Configuration
@Import({ HibernateConfig.class })
public class AppConfig {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public AlcoholicDrinksDao alcoholicDrinksDao() {
        AlcoholicDrinksDaoImpl dao = new AlcoholicDrinksDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao() {
        AlcoholicDrinksVolumeDaoImpl dao = new AlcoholicDrinksVolumeDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

    @Bean
    public ComparisonDao comparisonDao() {
        ComparisonDaoImpl dao = new ComparisonDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }

}

package mu.dl661.cst3130.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksDaoImpl;

@Configuration
@Import({HibernateConfig.class})
public class AppConfig {

    @Autowired
    private SessionFactory sessionFactory;

    @Bean
    public AlcoholicDrinksDao alcoholicDrinksDao() {
        AlcoholicDrinksDaoImpl dao = new AlcoholicDrinksDaoImpl();
        dao.setSessionFactory(sessionFactory);
        return dao;
    }
    
}

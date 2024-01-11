package mu.dl661.cst3130.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksDaoImpl;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDaoImpl;
import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.dao.ComparisonDaoImpl;
import mu.dl661.cst3130.service.AlcoholicDrinksServiceImp;
import mu.dl661.cst3130.service.AlcoholicDrinksVolumeServiceImpl;
import mu.dl661.cst3130.service.ComparisonServiceImpl;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "mu.dl661.cst3130.model" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driver"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.user"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.connection.pool_size",
                env.getProperty("hibernate.connection.pool_size"));
        hibernateProperties.setProperty("hibernate.current_session_context_class",
                env.getProperty("hibernate.current_session_context_class"));
        // hibernateProperties.setProperty("hibernate.format_sql",
        // env.getProperty("hibernate.format_sql"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return hibernateProperties;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }

    @Bean
    public AlcoholicDrinksDao alcoholicDrinksDao() {
        AlcoholicDrinksDaoImpl dao = new AlcoholicDrinksDaoImpl();
        dao.setSessionFactory(sessionFactory().getObject());
        return dao;
    }

    @Bean
    public AlcoholicDrinksServiceImp alcoholicDrinksServiceImp() {
        AlcoholicDrinksServiceImp alcoholicDrinksService = new AlcoholicDrinksServiceImp();
        alcoholicDrinksService.setAlcoholicDrinksDao(alcoholicDrinksDao());
        return alcoholicDrinksService;
    }

    @Bean
    public AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao() {
        AlcoholicDrinksVolumeDaoImpl dao = new AlcoholicDrinksVolumeDaoImpl();
        dao.setSessionFactory(sessionFactory().getObject());
        return dao;
    }

    @Bean
    public AlcoholicDrinksVolumeServiceImpl alcoholicDrinksVolumeServiceImpl() {
        AlcoholicDrinksVolumeServiceImpl alcoholicDrinksVolumeService = new AlcoholicDrinksVolumeServiceImpl();
        alcoholicDrinksVolumeService.setAlcoholicDrinksVolumeDao(alcoholicDrinksVolumeDao());
        return alcoholicDrinksVolumeService;
    }

    @Bean
    public ComparisonDao comparisonDao() {
        ComparisonDaoImpl dao = new ComparisonDaoImpl();
        dao.setSessionFactory(sessionFactory().getObject());
        return dao;
    }

    @Bean
    public ComparisonServiceImpl comparisonService() {
        ComparisonServiceImpl comparisonService = new ComparisonServiceImpl();
        comparisonService.setComparisonDao(comparisonDao());
        return comparisonService;
    }

}

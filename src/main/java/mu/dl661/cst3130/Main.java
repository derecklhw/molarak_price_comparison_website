package mu.dl661.cst3130;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mu.dl661.cst3130.config.HibernateConfig;
import mu.dl661.cst3130.service.AlcoholicDrinksService;
import mu.dl661.cst3130.threading.ThreadManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
      public static void main(String[] args) {
            Logger logger = LoggerFactory.getLogger(Main.class);

            // delete all alcoholic drinks from database
            deleteAllAlcoholicDrinks();
            logger.info("Deleted all alcoholic drinks from database");

            ThreadManager threadManager = new ThreadManager();
            threadManager.runScraperThreads();
            ;
      }

      private static void deleteAllAlcoholicDrinks() {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
            AlcoholicDrinksService alcoholicDrinksService = context.getBean(AlcoholicDrinksService.class);
            alcoholicDrinksService.deleteAllAlcoholicDrinks();
            context.close();
      }
}
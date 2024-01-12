package mu.dl661.cst3130;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mu.dl661.cst3130.config.HibernateConfig;
import mu.dl661.cst3130.model.AlcoholicDrinks;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;
import mu.dl661.cst3130.model.Comparison;
import mu.dl661.cst3130.service.AlcoholicDrinksService;
import mu.dl661.cst3130.threading.ThreadManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
      public static void main(String[] args) {
            Logger logger = LoggerFactory.getLogger(Main.class);

            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

            AlcoholicDrinksService alcoholicDrinksService = context.getBean(AlcoholicDrinksService.class);

            alcoholicDrinksService.deleteAllAlcoholicDrinks();

            AlcoholicDrinks alcoholicDrinks = new AlcoholicDrinks("kok", "description", "brand", "category",
                        "imageUrl");

            AlcoholicDrinksVolume alcoholicDrinksVolume = new AlcoholicDrinksVolume(alcoholicDrinks, 330);

            Comparison comparison = new Comparison(alcoholicDrinksVolume, "Amazon", "https://www.amazon.ca/", 2);

            alcoholicDrinksService.saveAlcoholicDrinks(alcoholicDrinks, alcoholicDrinksVolume, comparison);

            logger.info("Alcoholic Drink: " + alcoholicDrinks.getName() + " saved successfully");
            // // close resources
            context.close();
            // ThreadManager threadManager = new ThreadManager();
            // threadManager.runScraperThreads();
            ;
      }
}
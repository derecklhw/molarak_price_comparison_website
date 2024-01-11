package mu.dl661.cst3130;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mu.dl661.cst3130.config.HibernateConfig;
import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.dao.AlcoholicDrinksVolumeDao;
import mu.dl661.cst3130.dao.ComparisonDao;
import mu.dl661.cst3130.model.AlcoholicDrinks;
import mu.dl661.cst3130.model.AlcoholicDrinksVolume;
import mu.dl661.cst3130.model.Comparison;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
      public static void main(String[] args) {
            Logger logger = LoggerFactory.getLogger(Main.class);

            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

            AlcoholicDrinksDao alcoholicDrinksDao = context.getBean(AlcoholicDrinksDao.class);
            AlcoholicDrinks alcoholicDrinks = new AlcoholicDrinks();

            alcoholicDrinks.setName("Beer");
            alcoholicDrinks
                        .setDescription(
                                    "Beer is an alcoholic drink made from yeast-fermented malt and flavored with hops.");
            alcoholicDrinks.setBrand("Heineken");
            alcoholicDrinks.setCategory("Lager");
            alcoholicDrinks.setImageUrl(
                        "https://www.heineken.com/ca/~/media/Heineken/Images/Products/Heineken/Heineken-Beer-Can-330ml.png");

            alcoholicDrinksDao.saveAlcoholicDrinks(alcoholicDrinks);

            logger.info("AlcoholicDrinks::" + alcoholicDrinks.getId());

            AlcoholicDrinksVolumeDao alcoholicDrinksVolumeDao = context.getBean(AlcoholicDrinksVolumeDao.class);
            AlcoholicDrinksVolume alcoholicDrinksVolume = new AlcoholicDrinksVolume();

            alcoholicDrinksVolume.setAlcoholicDrink(alcoholicDrinks);
            alcoholicDrinksVolume.setVolume(330);
            alcoholicDrinksVolumeDao.saveAlcoholicDrinksVolume(alcoholicDrinksVolume);

            logger.info("AlcoholicDrinksVolume::" + alcoholicDrinksVolume.getId());

            ComparisonDao comparisonDao = context.getBean(ComparisonDao.class);
            Comparison comparison = new Comparison();

            comparison.setAlcoholicDrinkVolume(alcoholicDrinksVolume);
            comparison.setWebsiteName("Amazon");
            comparison.setWebsiteUrl("https://www.amazon.ca/");
            comparison.setPrice(2);
            comparisonDao.saveComparison(comparison);

            logger.info("Comparison::" + comparison.getId());

            // close resources
            context.close();
      }
}
package mu.dl661.cst3130;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mu.dl661.cst3130.config.AppConfig;
import mu.dl661.cst3130.dao.AlcoholicDrinksDao;
import mu.dl661.cst3130.model.AlcoholicDrinks;

public class Main {
   public static void main( String[] args ) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      String[] beanNames = context.getBeanDefinitionNames();
      System.out.println("Beans in the application context:");
      for (String beanName : beanNames) {
          System.out.println(beanName);
      }
      AlcoholicDrinksDao alcoholicDrinksDao = context.getBean(AlcoholicDrinksDao.class);
      AlcoholicDrinks alcoholicDrinks = new AlcoholicDrinks();
      
      alcoholicDrinks.setName("Beer");
      alcoholicDrinks.setDescription("Beer is an alcoholic drink made from yeast-fermented malt and flavored with hops.");
      alcoholicDrinks.setBrand("Heineken");
      alcoholicDrinks.setCategory("Lager");
      alcoholicDrinks.setImage(null);
      
      alcoholicDrinksDao.saveAlcoholicDrinks(alcoholicDrinks);

      context.close();
   }
}
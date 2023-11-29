package mu.dl661.cst3130;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mu.dl661.cst3130.config.AppConfig;

public class Main {
   public static void main( String[] args ) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      System.out.println(context.getBean("sessionFactory"));

      context.close();
   }
}
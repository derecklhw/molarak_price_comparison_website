package mu.dl661.cst3130;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
   public static void main( String[] args ) {
      System.out.println( "Hello World!" );

      Configuration config = new org.hibernate.cfg.Configuration();
      config.configure();

      SessionFactory factory = config.buildSessionFactory();
      System.out.println(factory);

      SeleniumDemo seleniumDemo = new SeleniumDemo();
      seleniumDemo.showAsdaHTML();
   }

}
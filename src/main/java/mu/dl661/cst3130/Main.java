package mu.dl661.cst3130;

// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// /**
//  * Contains main method for application
//  */
// public class Main {

//    public static void main(String[] args) { 
//       // runApplicationsXMLConfig();
//        runApplicationAnnotationsConfig();
       
//    }
   
// //    /** Uses Spring XML configuration to set up and run application */
// //    static void runApplicationsXMLConfig(){
// //         //Instruct Spring to create and wire beans using XML file
// //         ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
// //         //Get Car bean
// //         Car car = (Car) context.getBean("myCar");
        
// //         //Call methods on car bean
// //         car.drive();
// //    }
   
   
//    /** Uses Spring Annotation configuration to set up and run application */
//    static void runApplicationAnnotationsConfig(){
//        //Instruct Spring to create and wire beans using annotations.
//         ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
   
//         //Get Car bean
//         Car car = (Car) context.getBean("myCar");
        
//         //Call methods on car bean
//         car.drive();
//    }
   
// }

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class Main {
   public static void main( String[] args ) {
      System.out.println( "Hello World!" );

      Configuration config = new org.hibernate.cfg.Configuration();
      config.configure();

      SessionFactory factory = config.buildSessionFactory();
      System.out.println(factory);
   }

}
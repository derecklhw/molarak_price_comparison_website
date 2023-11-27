package mu.dl661.cst3130;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.List;

/** Demonstrates how you can use Selenium Chrome Driver to access data from websites
    that load data dynamically with JavaScript */
public class SeleniumDemo {

    /** Demonstrates use of ChromeDriver with Selenium */
    public void showAsdaHTML(){
        //We need an options class to run headless - not needed if we want default options
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        
        //Create instance of web driver - this must be on the path.
        WebDriver driver = new ChromeDriver(options);

        //Navigate Chrome to page.
        driver.get("https://groceries.asda.com/search/cake");

        //Wait for page to load
        try {
            Thread.sleep(3000);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        //Output the HTML of the page - should contain products
        System.out.println(driver.getPageSource());

        //Output details for individual products
        List<WebElement> cakeList = driver.findElements(By.className("co-product__anchor"));
        for (WebElement cake : cakeList) {
            System.out.println(cake.getText());
        }

        //Exit driver and close Chrome
        driver.quit();
    }


}
